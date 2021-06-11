package com.shiju.test;

import com.github.pagehelper.PageInfo;
import com.shiju.domain.User;
import com.shiju.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author shiju
 * @date 2021/06/10 14:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void testFindByPage() {
        PageInfo<User> info = userService.findByPage(1, 5);
        System.out.println(info.getList());
    }

    @Test
    public void testFindById() {
        User user = userService.findById(5);
        System.out.println("user = " + user);
    }

    @Test
    public void testSave() throws ParseException {
        User user = new User();
        user.setUsername("smith");
        user.setPassword("123456");
        user.setGender("男");
        user.setRealname("斯密丝");
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1999-2-18"));
        userService.save(user);
    }

    @Test
    public void testUpdate() throws ParseException {
        User user = new User();
        user.setId(7);
        user.setUsername("smith");
        user.setPassword("123");
        user.setGender("女");
        user.setRealname("斯密丝");
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1999-10-18"));
        userService.update(user);
    }

    @Test
    public void testDelete() {
        userService.delete(8);
    }
}
