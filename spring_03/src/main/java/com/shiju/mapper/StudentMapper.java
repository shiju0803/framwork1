package com.shiju.mapper;

import com.shiju.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.IOException;
import java.util.List;

/**
 * @author shiju
 * @date 2021/06/04 11:07
 */
public interface StudentMapper {
    /**
     * 查询全部
     */
    @Select("select * from student")
    public abstract List<Student> findAll();

    /**
     * 根据id查询
     */
    @Select("select * from student where id = #{id}")
    public abstract Student findById(Integer id);

    /**
     * 新增数据
     */
    @Insert("insert into student values(name = #{name},age = #{age}) where id = #{id}")
    public abstract void insert(Student stu) throws IOException;

    /**
     * 修改数据
     */
    @Update("update student set name = #{name},age = #{age} where id = #{id}")
    public abstract void update(Student stu) throws IOException;

    /**
     * 删除数据
     */
    @Delete("delete from student where id = #{id}")
    public abstract void delete(Integer id) throws IOException;

    /**
     * 转账
     */
    public void transfer(Integer outId, Integer inId, double money);
}
