package com.shiju.test;
import com.shiju.bean.Student;
import com.shiju.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class StudentTest {

    @Test
    public void test1() throws IOException {
        //创建Spring容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取service对象
        StudentService studentService = ac.getBean("studentService", StudentService.class);
        List<Student> list = studentService.selectAll();
        list.forEach(stu-> System.out.println(stu));
    }


    @Test
    public void test2() throws IOException {
        //创建Spring容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取service对象
        StudentService studentService = ac.getBean("studentService", StudentService.class);
        Student stu = studentService.selectById(6);
        System.out.println("stu = " + stu);
    }
}
