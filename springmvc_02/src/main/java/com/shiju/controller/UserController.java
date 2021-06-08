package com.shiju.controller;

import com.shiju.domain.User;
import com.shiju.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiju
 * @date 2021/06/08 20:52
 */
@Controller
public class UserController {
    @RequestMapping("save")
    @ResponseBody
    public List<User> save(@RequestBody User user) {
        System.out.println(user);
        if (user.getName().trim().length() < 8) {
            throw new BusinessException("对不起，用户名长度不满足要求，请重新输入！");
        }
        if (user.getAge() < 0) {
            throw new BusinessException("对不起，年龄必须是0到100之间的整数，请重新输入！");
        }
        if (user.getAge() > 100) {
            throw new BusinessException("服务器连接失败，请尽快检查处理！");
        }
        List<User> list = new ArrayList<>();
        User user1 = new User("黄桂田", 38);
        User user2 = new User("黄小田", 34);
        User user3 = new User("黄啸天", 43);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
}
