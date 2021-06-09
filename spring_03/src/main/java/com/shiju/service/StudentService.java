package com.shiju.service;

import com.shiju.domain.Student;

import java.io.IOException;
import java.util.List;

/**
 * @author shiju
 * @date 2021/06/04 09:30
 */
public interface StudentService {
    /**
     * 查询全部
     */
    public abstract List<Student> findAll() throws IOException;

    /**
     * 根据id查询
     */
    public abstract Student findById(Integer id) throws IOException;

    /**
     * 新增数据
     */
    public abstract void insert(Student stu) throws IOException;

    /**
     * 修改数据
     */
    public abstract void update(Student stu) throws IOException;

    /**
     * 删除数据
     */
    public abstract void delete(Integer id) throws IOException;

    /**
     * 转账
     */
    public void transfer(Integer outId, Integer inId, double money);
}
