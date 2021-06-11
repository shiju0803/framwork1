package com.shiju.service;

import com.github.pagehelper.PageInfo;
import com.shiju.domain.User;

import java.util.List;

/**
 * @author shiju
 * @date 2021/06/10 14:13
 */
public interface UserService {
    /**
     * 查询所有用户信息
     *
     * @return 所有用户信息
     */
    List<User> findAll();

    /**
     * 分页查询用户信息
     *
     * @param currentPage 当前页
     * @param pageSize    每页条数
     * @return 分页数据
     */
    PageInfo<User> findByPage(int currentPage, int pageSize);

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User findById(Integer id);

    /**
     * 保存用户信息
     *
     * @param user 要保存用户对象
     * @return 影响的行数
     */
    int save(User user);

    /**
     * 修改用户信息
     *
     * @param user 要修改的用户对象
     * @return 影响的行数
     */
    int update(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id 要删除的用户id
     * @return 影响的行数
     */
    int delete(Integer id);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户对象
     */
    User login(String username, String password);
}
