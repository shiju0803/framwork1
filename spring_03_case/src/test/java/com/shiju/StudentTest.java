package com.shiju;

import com.shiju.config.SpringConfiguration;
import com.shiju.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author shiju
 * @date 2021/06/04 18:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void test1() {
        studentService.selectAll();
    }

    @Test
    public void test2() throws IOException {

        //执行操作，调用service的方法
        studentService.selectById(3);
    }
}
