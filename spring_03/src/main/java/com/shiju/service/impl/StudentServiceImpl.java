package com.shiju.service.impl;

import com.shiju.domain.Student;
import com.shiju.service.StudentService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author shiju
 * @date 2021/06/04 09:30
 */
@Service
public class StudentServiceImpl implements StudentService {
    /**
     * 查询全部
     */
    @Override
    public List<Student> findAll() throws IOException {
        System.out.println("查询所有学生信息findAll...");
        return null;
    }

    /**
     * 根据id查询
     */
    @Override
    public Student findById(Integer id) throws IOException {
        System.out.println("根据id查询学生信息findById...");
        return null;
    }

    /**
     * 新增数据
     */
    @Override
    public void insert(Student stu) throws IOException {
        //执行添加操作
        System.out.println("添加学生信息insert...");
    }

    /**
     * 修改数据
     */
    @Override
    public void update(Student stu) throws IOException {
        System.out.println("修改学生信息update...");
    }

    /**
     * 删除数据
     */
    @Override
    public void delete(Integer id) throws IOException {
        System.out.println("根据id删除学生信息delete...");
        //int i=100/0;
    }

    /**
     * 转账
     */
    @Override
    public void transfer(Integer outId, Integer inId, double money) {
        //张三账户-1000
        System.out.println("调用dao:张三(" + outId + ")的账户" + (-money) + "元");
        //李四的账户+1000
        System.out.println("调用dao:李四(" + inId + ")的账户" + (+money) + "元");
    }
}
