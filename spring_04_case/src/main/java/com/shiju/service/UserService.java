package com.shiju.service;

import com.shiju.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    /**
     * 定义登录的方法
     * @param user 封装用于登录的用户名和密码
     * @return 返回查到的用户信息
     */
    User login(User user);
}
