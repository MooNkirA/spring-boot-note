package com.moon.springboot.caching;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
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
@EnableMethodCache(basePackages = "com.moon.springboot.caching") // 开启方法注解缓存支持，basePackages 指定扫描方法缓存注解的包路径
public class JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run((JetcacheApplication.class), args);
    }

}
