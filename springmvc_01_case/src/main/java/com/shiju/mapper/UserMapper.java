package com.shiju.mapper;

import com.shiju.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /**
     * 定义登录的方法
     *
     * @param user 封装用于登录的用户名和密码
     * @return 返回查到的用户信息
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);
}
