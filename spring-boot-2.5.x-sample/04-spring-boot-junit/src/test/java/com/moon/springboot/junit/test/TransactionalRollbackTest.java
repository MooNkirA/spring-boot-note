package com.moon.springboot.junit.test;

import com.moon.springboot.junit.domain.Account;
import com.moon.springboot.junit.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 数据层测试回滚
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-21 23:16
 * @description
 */
@SpringBootTest
@Transactional // 标识测试程序不需要提交事务
@Rollback(true) // 设置回滚状态（默认值为 true，不提交事务），设置为 false 时，正常提交事务
public class TransactionalRollbackTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testRollback() {
        Account account = new Account();
        account.setName("MooNkira");
        account.setMoney(new BigDecimal("1098.82"));

        System.out.println(accountService.save(account));
    }
}
