package com.moon.springboot.h2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-24 15:59
 * @description
 */
@SpringBootApplication
@MapperScan("com.moon.springboot.h2.mapper")
public class H2Application {

    public static void main(String[] args) {
        SpringApplication.run(H2Application.class, args);
    }

}
