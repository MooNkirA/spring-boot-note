package com.moon.springboot.hikaricp.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moon.springboot.hikaricp.dao.AccountDao;
import com.moon.springboot.hikaricp.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 内置数据源 HikariCP 测试
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-23 23:17
 * @description
 */
@SpringBootTest
public class HikariCPTest {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testBasic() {
        List<Account> accounts = accountDao.selectList(new QueryWrapper<>());
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}
