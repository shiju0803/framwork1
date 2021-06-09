package com.shiju.test;

import com.shiju.domain.Student;
import com.shiju.dtatSource.MyDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shiju
 * @date 2021/06/01 21:54
 */
public class MyDataSourceTset {
    @Test
    public void test() throws SQLException {
        //获取connection对象
        MyDataSource dataSource = new MyDataSource();
        Connection conn = dataSource.getConnection();
        //调用连接方法
        PreparedStatement pstmt = conn.prepareStatement("select * from student");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3));
            System.out.println(student);
        }
        System.out.println("释放前：" + dataSource.getSize());
        //释放资源
        conn.close();
        System.out.println("释放后：" + dataSource.getSize());
        System.out.println(pstmt);
    }
}
