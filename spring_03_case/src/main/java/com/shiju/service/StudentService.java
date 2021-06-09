package com.shiju.service;

import com.shiju.domain.Student;

import java.util.List;

/**
 * @author shiju
 * @date 2021/06/04 18:11
 */
public interface StudentService {
    //查询全部
    public abstract List<Student> selectAll();

    //根据id查询
    public abstract Student selectById(Integer id);

    //新增数据
    public abstract Integer insert(Student stu);

    //修改数据
    public abstract Integer update(Student stu);

    //删除数据
    public abstract Integer delete(Integer id);
}
