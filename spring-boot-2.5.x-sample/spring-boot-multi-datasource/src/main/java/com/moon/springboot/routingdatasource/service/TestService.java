package com.moon.springboot.routingdatasource.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用于测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-02-15 13:48
 * @description
 */
@Service
public class TestService {

    private final JdbcTemplate jdbcTemplate;

    public TestService(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // 只读
    @Transactional(readOnly = true)
    public String read() {
        return this.jdbcTemplate.queryForObject("SELECT `name` FROM `test` WHERE id = 1;", String.class);
    }


    // 先读，再写
    @Transactional
    public String write() {
        this.jdbcTemplate.update("UPDATE `test` SET `name` = ? WHERE id = 1;", "new name");
        return this.read();
    }

}
