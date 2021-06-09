package com.shiju.test;

import com.shiju.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountTest {

    @Autowired
    private AccountService accountService;


    /**
     *
     */
    @Test
    public void testTransfer() {
        //需求：jack给rose转100元
        accountService.transfer(1, 2, 100.0);
    }

    @Test
    public void testTransfer2() {
        //需求：jack给rose转100元
        accountService.transfer2(1, 2, 100.0);
    }
}
