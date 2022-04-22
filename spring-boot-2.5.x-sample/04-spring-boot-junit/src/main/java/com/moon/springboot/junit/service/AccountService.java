package com.moon.springboot.junit.service;

import com.moon.springboot.junit.domain.Account;

/**
 * 业务层接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-22 21:37
 * @description
 */
public interface AccountService {

    boolean save(Account account);

}
