package com.shiju.controller;

import com.shiju.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @RequestMapping("/ajaxController")
    @ResponseBody
    public void ajaxController() {
        System.out.println("ajaxController is running...");
    }


    @RequestMapping("/ajaxPojoToController")
    public void ajaxPojoToController(@RequestBody User user) {
        System.out.println("ajaxPojoToController is running... " + user);
    }


    //如果处理参数是List集合且封装了POJO，且页面发送的数据是JSON格式的对象数组，数据将自动映射到集合参数中
    @RequestMapping("/ajaxListToController")
    public void ajaxListToController(@RequestBody List<User> list) {
        System.out.println("ajaxPojoToController is running... " + list);
    }


    //使用注解@ResponseBody可以将返回的页面不进行解析，直接返回字符串，该注解可以添加到方法上方或返回值前面
    @RequestMapping("/ajaxReturnString")
    @ResponseBody
    public String ajaxReturnString() {
        return "hello";
    }


    //基于jackon技术，使用@ResponseBody注解可以将返回的POJO对象转成json格式数据
    @RequestMapping("/ajaxReturnJson")
    @ResponseBody
    public User ajaxReturnJson() {
        User user = new User();
        user.setName("黄桂田");
        user.setAge(32);
        return user;
    }


    //基于jackon技术，使用@ResponseBody注解可以将返回的保存POJO对象的集合转成json数组格式数据
    @RequestMapping("/ajaxReturnJsonList")
    @ResponseBody
    public List<User> ajaxReturnJsonList() {
        List<User> list = new ArrayList<>();
        User user1 = new User("黄桂田", 38);
        User user2 = new User("黄小田", 34);
        User user3 = new User("黄啸天", 43);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }

    //使用@CrossOrigin开启跨域访问
    //标注在处理器方法上方表示该方法支持跨域访问
    //标注在处理器类上方表示该处理器类中的所有处理器方法均支持跨域访问
    @RequestMapping("/cross")
    @ResponseBody
    @CrossOrigin //表示运行跨域访问
    public User cross() {
        User user = new User("黄桂田", 32);
        return user;
    }
}
