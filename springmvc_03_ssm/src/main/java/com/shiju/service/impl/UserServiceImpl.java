package com.shiju.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiju.domain.User;
import com.shiju.mapper.UserMapper;
import com.shiju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shiju
 * @date 2021/06/10 14:14
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    /**
     * 查询所有用户信息
     *
     * @return 所有用户信息
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return mapper.selectAll();
    }

    /**
     * 分页查询用户信息
     *
     * @param currentPage 当前页
     * @param pageSize    每页条数
     * @return 分页数据
     */
    @Override
    @Transactional(readOnly = true)
    public PageInfo<User> findByPage(int currentPage, int pageSize) {
        //设置分页参数
        PageHelper.startPage(currentPage, pageSize);
        //查询所有
        List<User> list = mapper.selectAll();
        //封装分页结果并返回
        return new PageInfo<>(list);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return mapper.findById(id);
    }

    /**
     * 保存用户信息
     *
     * @param user 要保存用户对象
     * @return 影响的行数
     */
    @Override
    public int save(User user) {
        return mapper.save(user);
    }

    /**
     * 修改用户信息
     *
     * @param user 要修改的用户对象
     * @return 影响的行数
     */
    @Override
    public int update(User user) {
        return mapper.update(user);
    }

    /**
     * 根据id删除用户信息
     *
     * @param id 要删除的用户id
     * @return 影响的行数
     */
    @Override
    public int delete(Integer id) {
        int a = mapper.delete(id);
        //int i = 1 / 0;
        return a;
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户对象
     */
    @Override
    @Transactional(readOnly = true)
    public User login(String username, String password) {
        return mapper.findUserByUsernameAndPassword(username, password);
    }
}
