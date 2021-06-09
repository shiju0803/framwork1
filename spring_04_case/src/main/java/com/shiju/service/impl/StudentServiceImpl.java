package com.shiju.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiju.domain.Student;
import com.shiju.mapper.StudentMapper;
import com.shiju.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    //注入mapper
    @Autowired
    private StudentMapper mapper;
    /**
     * 分页查询方法
     * @param currentPage 当前页数
     * @param pageSize 每页展示条数
     * @return 返回PageInfo分页结果对象
     */
    @Override
    public PageInfo<Student> selectByPage(int currentPage, int pageSize) {
        //设置分页数据（当前页和每页展示的条数）
        PageHelper.startPage(currentPage,pageSize);
        //执行操作
        Page<Student> page = mapper.findAll();
        //封装分页信息
        return new PageInfo<>(page);
    }

    /**
     * 添加学生信息
     * @param student 要添加的学生对象
     * @return 返回影响的行数，1表示成功，0表示失败
     */
    @Override
    public int addStudent(Student student) {
        return mapper.addStudent(student);
    }

    /**
     * 修改学生的方法
     * @param student 要修改的学生对象
     * @return 返回影响的行数，1表示成功，0表示失败
     */
    @Override
    public int updateStudent(Student student) {
        int count = mapper.updateStudent(student);
        return count;
    }

    /**
     * 删除学生的方法
     * @param number 学生的编号
     * @return 返回影响的行数，1表示成功，0表示失败
     */
    @Override
    public int deleteStudent(String number) {
        int count = mapper.deleteStudent(number);
        return count;
    }
}
