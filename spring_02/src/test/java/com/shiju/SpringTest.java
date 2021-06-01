package com.shiju;

import com.alibaba.druid.pool.DruidDataSource;
import com.shiju.config.SpringConfiguration;
import com.shiju.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SpringTest {

    @Test
    public void test1() {
        //需求：从spring容器中获取userService对象，并调用save方法
        //1 创建spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 从spring容器中获取userService对象
        //UserService userService = (UserService) ac.getBean("userService");
        //UserService userService = ac.getBean(UserService.class);
        UserService userService = ac.getBean("userService", UserService.class);
        //3 调用save方法
        userService.save();
    }

    @Test
    public void test3() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/heima_mm");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    @Test
    public void test4() throws SQLException {
        //1 创建spring容器对象
        //ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2 从spring容器中获取连接池对象
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        //3 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}