package com.shiju.service.impl;

import com.shiju.mapper.UserDao;
import com.shiju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    private String name;
    private int age;
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(String name, int age, UserDao userDao) {
        this.name = name;
        this.age = age;
        this.userDao = userDao;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl save is running..." + name + "..." + age);
        userDao.save();
    }
}