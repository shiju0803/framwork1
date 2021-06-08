package com.shiju.controller;

import com.shiju.domain.User;
import com.shiju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 处理登录的请求
     */
    @RequestMapping("login")
    protected boolean login(User user, HttpSession session) {
        //2 调用service层的login方法，得到新的user对象
        User existUser = userService.login(user);

        //3 判断如果user!=null,说明登录成功，将user保存到session
        if (existUser != null) {
            session.setAttribute("user", existUser);
        }
        return existUser != null;
    }
}
