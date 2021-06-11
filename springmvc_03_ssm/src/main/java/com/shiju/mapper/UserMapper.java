package com.shiju.mapper;

import com.shiju.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author shiju
 * @date 2021/06/10 14:05
 */
public interface UserMapper {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Select("select * from user")
    List<User> selectAll();

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 保存用户信息
     *
     * @param user 要保存用户对象
     * @return 影响的行数
     */
    @Insert("insert into user(username,password,realname,gender,birthday) values(#{username},#{password},#{realname},#{gender},#{birthday})")
    int save(User user);

    /**
     * 修改用户信息
     *
     * @param user 要修改的用户对象
     * @return 影响的行数
     */
    @Update("update user set username = #{username},password = #{password},realname=#{realname},gender=#{gender},birthday=#{birthday} where id = #{id}")
    int update(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id 要删除的用户id
     * @return 影响的行数
     */
    @Delete("delete from user where id = #{id}")
    int delete(Integer id);

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户对象
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
