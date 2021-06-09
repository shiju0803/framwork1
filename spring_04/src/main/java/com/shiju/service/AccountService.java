package com.shiju.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT)
public interface AccountService {

    @Transactional(
            readOnly = false,
            timeout = -1,
            isolation = Isolation.DEFAULT,
            rollbackFor = {},
            noRollbackFor = {},
            propagation = Propagation.REQUIRED
    )
    void transfer(Integer outId, Integer inId, Double money);

    void transfer2(Integer outId, Integer inId, Double money);
}
