package com.shiju.controller;

import com.github.pagehelper.PageInfo;
import com.shiju.domain.Student;
import com.shiju.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //等价于@Controller + @ResponseBody
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 处理分页查询的请求
     * 访问路径：http://localhost/student/1/5 + GET请求
     */
    @GetMapping("{currentPage}/{pageSize}")
    protected PageInfo<Student> selectByPage(@PathVariable Integer currentPage,
                                             @PathVariable Integer pageSize) {
        //2 调用service层方法获取结果PageInfo对象
        return studentService.selectByPage(currentPage, pageSize);
    }

    /**
     * 处理添加学生的请求
     * 访问路径：http://localhost/student + POST请求
     */
    @PostMapping
    protected int addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    /**
     * 处理修改学生的请求
     * 访问路径：http://localhost/student + PUT请求
     */
    @PutMapping
    protected int updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    /**
     * 处理删除学生的请求
     * 访问路径：http://localhost/student + DELETE请求
     */
    @DeleteMapping("{number}")
    protected int deleteStudent(@PathVariable String number) {
        return studentService.deleteStudent(number);
    }
}
