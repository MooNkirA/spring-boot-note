package com.moon.springboot.junit.service;

import com.moon.springboot.junit.dao.AccountDao;
import com.moon.springboot.junit.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层实现
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-22 21:38
 * @description
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean save(Account account) {
        return accountDao.insert(account) > 0;
    }

}
