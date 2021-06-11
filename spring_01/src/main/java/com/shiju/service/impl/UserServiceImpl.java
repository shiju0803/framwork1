package com.shiju.service.impl;

import com.shiju.mapper.UserDao;
import com.shiju.service.UserService;

/**
 * @author shiju
 * @date 2021/05/31 10:36
 */
public class UserServiceImpl implements UserService {
    private String name;
    private int age;
    private UserDao userDao;

    public UserServiceImpl() {
    }


    public UserServiceImpl(String name, int age, UserDao userDao) {
        this.name = name;
        this.age = age;
        this.userDao = userDao;
        System.out.println("构造方法。。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void say(){
        System.out.println("Hello Spring!" + name + "," + age);
        userDao.say();
    }

}
