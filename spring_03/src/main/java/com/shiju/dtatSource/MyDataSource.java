package com.shiju.dtatSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 自定义连接池工具类，使用动态代理解决连接归还问题
 *
 * @author shiju
 * @date 2021/06/01 20:49
 */
public class MyDataSource implements DataSource {
    //创建连接池容器对象，也就是一个List集合
    private static List<Connection> pool = Collections.synchronizedList(new ArrayList<>());

    //在静态代码块中读取配置文件，创建连接对象，保存到容器中
    static {
        //加载配置文件
        Properties prop = new Properties();
        InputStream is = MyDataSource.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            prop.load(is);
            //根据key获取value值
            String driverClass = prop.getProperty("jdbc.driverClassName");
            String url = prop.getProperty("jdbc.url");
            String username = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");
            //注册驱动
            Class.forName(driverClass);
            //for循环创建10个connection对象，存入容器中
            for (int i = 0; i < 10; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                pool.add(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //提供getSize()方法，获取连接池中连接的数量
    public int getSize() {
        return pool.size();
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (pool.size() == 0) {
            throw new RuntimeException("连接池数量用完了。。。");
        }
        //得到的是目标对象，不能直接返回目标对象，因为目标对象的close()方法是释放连接，不是归还连接
        Connection conn = pool.remove(0);//JDBC4Connection对象
        //给JDBC4Connection对象生成一个代理对象并返回
        /**
         * ClassLoader loader:类加载器，要求和目标对象使用一样的类加载器，底层使用类加载器创建代理对象的Class对象，
         *         有了Class对象就可以反射创建代理对象
         * Class<?>[] interfaces:接口们，要求和目标对象实现一样的接口（实现了相同的接口就意味着有相同的功能）
         * InvocationHandler h：接口类型，需要我们自己提供一个实现类对象，一般使用匿名内部类
         *          作用：在匿名内部类中处理代理对象增强逻辑
         */
        ClassLoader loader = conn.getClass().getClassLoader();
        //Class<?>[] interfaces = conn.getClass().getInterfaces();//无法获取到间接实现的接口，所以不能这么用
        Class<?>[] interfaces = {Connection.class};//直接声明要实现的接口
        //参数二就是让代理对象和目标对象实现相同接口，所以代理对象也实现了Connection接口，所以可以类型转换
        Connection proxy = (Connection) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            /**
             * 该方法就是代理对象用来处理增强的逻辑方法，外界只要代理对象的任何方法，该方法就会执行
             * @param proxy 表示代理对象，和Proxy.newProxyInstance()的返回值对象是同一个对象
             * @param method 表示外界调用了代理对象的那个方法对应的Method对象
             * @param args 表示外界调用了代理对象方法传递的参数
             * @return 那里调用了代理对象的方法，就将返回值返回到哪里
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object value = null;
                if (method.getName().equals("close")) {
                    pool.add(conn);
                } else {
                    //如果调用的不是close方法，那么就不增强，调用原来的connection的对应的方法
                    value = method.invoke(conn, args);
                }
                return value;
            }
        });
        return proxy;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
