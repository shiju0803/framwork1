package com.shiju.test;

import com.shiju.bean.Student;
import com.shiju.config.SpringConfiguration;
import com.shiju.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

//【第二步】使用spring中提供的单元测试运行类替换JVM中单元测试运行类
@RunWith(SpringJUnit4ClassRunner.class)
//【第三步】加载配置文件或者配置类
@ContextConfiguration(classes = {SpringConfiguration.class}) //加载配置类
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})//加载配置文件
public class StudentTest {
    @Autowired  //自动按照类型注入对象
    private StudentService studentService;

    /**
     * 测试查询所有学生
     */
    @Test
    public void test1() throws IOException {
        //创建Spring容器对象
        //ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //获取service对象
        StudentService studentService = ac.getBean("studentService", StudentService.class);
        List<Student> list = studentService.selectAll();
        list.forEach(stu -> System.out.println(stu));
    }

    /**
     * 根据id查询学生
     */
    @Test
    public void test2() throws IOException {
        //创建Spring容器对象
        //ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //获取service对象
        StudentService studentService = ac.getBean("studentService", StudentService.class);
        Student student = studentService.selectById(6);
        System.out.println(student);
    }

    /**
     * 测试添加学生
     */
    @Test
    public void test3() throws IOException {
        Student student = new Student(0, "黄桂田", 23);
        Integer i = studentService.insert(student);
        System.out.println(i);
    }

    @Test
    public void test6() throws IOException {
        //创建Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取service对象
        StudentService studentService = ac.getBean("studentService", StudentService.class);
        Student stu = studentService.selectById(6);
        System.out.println("stu = " + stu);
    }
}
