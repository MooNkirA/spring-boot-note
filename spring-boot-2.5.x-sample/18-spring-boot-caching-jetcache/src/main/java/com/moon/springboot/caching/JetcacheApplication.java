package com.moon.springboot.caching;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 22:25
 * @description
 */
@SpringBootApplication
@EnableCreateCacheAnnotation // jetcache 启用缓存支持
public class JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run((JetcacheApplication.class), args);
    }

}
