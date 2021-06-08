package com.shiju.service.impl;

import com.shiju.domain.User;
import com.shiju.mapper.UserMapper;
import com.shiju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    //注入mapper
    @Autowired
    private UserMapper mapper;

    /**
     * 定义登录的方法
     *
     * @param user 封装用于登录的用户名和密码
     * @return 返回查到的用户信息
     */
    @Override
    public User login(User user) {

        //返回结果
        return mapper.login(user);
    }
}
