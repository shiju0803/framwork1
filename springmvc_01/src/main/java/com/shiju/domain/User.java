package com.shiju.domain;

import java.util.List;

public class User {
    private String name;
    private Integer age;
    private List<String> nick;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getNick() {
        return nick;
    }

    public void setNick(List<String> nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nick=" + nick +
                '}';
    }
}
