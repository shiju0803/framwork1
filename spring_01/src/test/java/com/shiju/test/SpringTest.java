package com.shiju.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.shiju.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * @author shiju
 * @date 2021/05/31 10:36
 */
public class SpringTest {

    @Test
    public void test1(){
        //创建spring容器对象，读取配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取bean对象
        //UserService service = (UserService) ac.getBean("userService");
        //UserService userService = ac.getBean(UserService.class);//如果该类型的对象有多个，会报错找不到
        UserService userService = ac.getBean("userService",UserService.class);
        //调用对象方法
        userService.say();
    }

    @Test
    public void test2(){
        //创建spring容器对象，读取配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取bean对象
        Calendar calendar = ac.getBean("calendar",Calendar.class);
        //调用对象方法
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "-" + month + "-" + day);
    }

    /**
     *  druid jdbc连接测试
     */
    @Test
    public void test3() throws SQLException {
        //创建spring容器对象，读取配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取bean对象
        DataSource dataSource = ac.getBean("dataSource",DruidDataSource.class);
        //获取连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
