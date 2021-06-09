package com.shiju.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {

    @Update("update account set money=money+#{money} where id=#{id}")
    void transfer(@Param("id") Integer Id, @Param("money") Double money);
}
