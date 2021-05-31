package com.shiju.test;
import com.shiju.bean.Student;
import com.shiju.service.StudentService;
import com.shiju.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class StudentTest {

    @Test
    public void test1() throws IOException {
        StudentService studentService=new StudentServiceImpl();
        List<Student> list = studentService.selectAll();
        list.forEach(stu-> System.out.println(stu));
    }


    @Test
    public void test2() throws IOException {
        StudentService studentService=new StudentServiceImpl();
        Student stu = studentService.selectById(6);
        System.out.println("stu = " + stu);
    }
}
