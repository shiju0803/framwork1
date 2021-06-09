package com.shiju.service;

import com.shiju.domain.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    //查询全部
    public abstract List<Student> selectAll() throws IOException;

    //根据id查询
    public abstract Student selectById(Integer id) throws IOException;

    //新增数据
    public abstract Integer insert(Student stu) throws IOException;

    //修改数据
    public abstract Integer update(Student stu) throws IOException;

    //删除数据
    public abstract Integer delete(Integer id) throws IOException;
}
