package com.moon.springboot.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 22:25
 * @description
 */
@SpringBootApplication
public class MemcachedApplication {

    public static void main(String[] args) {
        SpringApplication.run((MemcachedApplication.class), args);
    }

}
