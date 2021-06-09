package com.shiju.test;

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
 * @date 2021/06/04 11:13
 */
//【第二步】使用spring中提供的单元测试运行类替换JVM中单元测试运行类
@RunWith(SpringJUnit4ClassRunner.class)
//【第三步】加载配置文件或者配置类
@ContextConfiguration(classes = {SpringConfiguration.class}) //加载配置文件
public class StudentTest {
    @Autowired
    private StudentService service;

    @Test
    public void tset1() throws IOException {
        service.findAll();
    }

    @Test
    public void tset2() throws IOException {
        service.findById(1);
    }

    @Test
    public void test3() {
        service.transfer(1, 2, 1000);
    }
}
