package com.shiju.mapper;

import com.github.pagehelper.Page;
import com.shiju.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {

    /**
     * 查询所有学生信息
     *
     * @return
     */
    @Select("select * from student")
    Page<Student> findAll();

    /**
     * 添加学生信息
     *
     * @param student
     * @return 影响的行数
     */
    @Insert("insert into student values(#{number},#{name},#{birthday},#{address})")
    int addStudent(Student student);

    /**
     * 修改学生的方法
     *
     * @param student
     * @return
     */
    @Update("update student set name=#{name},birthday=#{birthday},address=#{address} where number=#{number}")
    int updateStudent(Student student);

    /**
     * 删除学生的方法
     *
     * @param number
     * @return
     */
    @Delete("delete from student where number=#{number}")
    int deleteStudent(String number);
}
