package com.shiju.service.impl;

import com.shiju.domain.Student;
import com.shiju.mapper.StudentMapper;
import com.shiju.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiju
 * @date 2021/06/04 18:10
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //查询全部
    @Override
    public List<Student> selectAll() {
        List<Student> list = studentMapper.selectAll();
        list.forEach(student -> System.out.println(student));
        return list;
    }

    //根据id查询
    @Override
    public Student selectById(Integer id) {
        Student student = studentMapper.selectById(id);
        System.out.println(student);
        return student;
    }

    //新增数据
    @Override
    public Integer insert(Student stu) {
        int i = studentMapper.insert(stu);
        if (i != 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
        return i;
    }

    //修改数据
    @Override
    public Integer update(Student stu) {
        int i = studentMapper.update(stu);
        if (i != 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
        return i;
    }

    //删除数据
    @Override
    public Integer delete(Integer id) {
        int i = studentMapper.delete(id);
        if (i != 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        return i;
    }
}
