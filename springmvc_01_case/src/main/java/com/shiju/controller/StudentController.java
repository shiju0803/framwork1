package com.shiju.controller;

import com.github.pagehelper.PageInfo;
import com.shiju.domain.Student;
import com.shiju.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 处理分页查询的请求
     */
    @RequestMapping("selectByPage")
    protected PageInfo<Student> selectByPage(Integer currentPage, Integer pageSize) {
        //2 调用service层方法获取结果PageInfo对象
        return studentService.selectByPage(currentPage, pageSize);
    }

    /**
     * 处理添加学生的请求
     */
    @RequestMapping("addStudent")
    protected int addStudent(Student student) {
        return studentService.addStudent(student);
    }

    /**
     * 处理修改学生的请求
     */
    @RequestMapping("updateStudent")
    protected int updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    /**
     * 处理删除学生的请求
     */
    @RequestMapping("deleteStudent")
    protected int deleteStudent(String number) {
        return studentService.deleteStudent(number);
    }
}
