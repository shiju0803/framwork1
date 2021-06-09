package com.shiju.service.impl;

import com.shiju.dao.AccountDao;
import com.shiju.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 编程式半注解式事务管理
     */
    @Override
    public void transfer(Integer outId, Integer inId, Double money) {
        //开启事务
        //创建事务管理器对象，并设置数据源
        PlatformTransactionManager ptm = new DataSourceTransactionManager(dataSource);
        //创建事务定义对象
        TransactionDefinition td = new DefaultTransactionDefinition();
        //创建事务状态对象，用于控制事务执行
        TransactionStatus ts = ptm.getTransaction(td);
        //outId减100元
        accountDao.transfer(outId, -money);
        //模拟业务层事务中的错误
        int a = 10 / 0;
        //inId加100元
        accountDao.transfer(inId, money);
        //提交事务
        ptm.commit(ts);
    }

    /**
     * 声明式事务管理（只配置，不编写代码）
     */
    @Override
    public void transfer2(Integer outId, Integer inId, Double money) {
        //outId减100元
        accountDao.transfer(outId, -money);
        // int a = 10 / 0;
        //inId加100元
        accountDao.transfer(inId, money);
    }
}
