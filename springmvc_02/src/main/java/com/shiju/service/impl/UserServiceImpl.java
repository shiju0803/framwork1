package com.shiju.service.impl;

import com.shiju.exception.SystemException;

import java.sql.SQLException;

/**
 * @author shiju
 * @date 2021/06/08 20:50
 * <p>
 * 模拟数据库连接超时异常
 */
public class UserServiceImpl {
    public void save() {
        try {
            throw new SQLException();
        } catch (SQLException e) {
            throw new SystemException("数据库连接超时", e);
        }
    }
}
