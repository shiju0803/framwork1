package com.shiju.service;

import com.github.pagehelper.PageInfo;
import com.shiju.domain.Student;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentService {
    /**
     * 分页查询方法
     *
     * @param currentPage 当前页数
     * @param pageSize    每页展示条数
     * @return
     */
    @Transactional(readOnly = true)
    PageInfo<Student> selectByPage(int currentPage, int pageSize);

    /**
     * 修改学生的方法
     *
     * @param student 要修改的学生对象
     * @return 返回影响的行数，1表示成功，0表示失败
     */
    @Transactional(readOnly = false)
    int addStudent(Student student);

    /**
     * 修改学生的方法
     *
     * @param student 要修改的学生对象
     * @return 返回影响的行数，1表示成功，0表示失败
     */
    int updateStudent(Student student);

    /**
     * 删除学生的方法
     *
     * @param number 学生的编号
     * @return 返回影响的行数，1表示成功，0表示失败
     */
    int deleteStudent(String number);
}
