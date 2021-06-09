package com.shiju.mapper;

import com.shiju.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/*
    持久层接口
 */
public interface StudentMapper {
    //查询全部
    @Select("select * from student")
    public abstract List<Student> selectAll();

    //根据id查询
    @Select("select * from student where id = #{id}")
    public abstract Student selectById(Integer id);

    //新增数据
    @Insert("insert into student values(#{id},#{name},#{age})")
    public abstract Integer insert(Student stu);

    //修改数据
    @Update("update student set name = #{name},age = #{age} where id = #{id}")
    public abstract Integer update(Student stu);

    //删除数据
    @Delete("delete from student where id = #{id}")
    public abstract Integer delete(Integer id);
}
