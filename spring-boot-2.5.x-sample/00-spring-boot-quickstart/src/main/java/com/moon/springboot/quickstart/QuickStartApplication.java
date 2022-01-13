package com.moon.springboot.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot快速开始入口类
 *
 * @author MoonZero
 * @version 1.0
 * @date 2022-1-12 11:41
 * @description
 */
@SpringBootApplication  // 此注解代表为SpringBoot应用的运行主类
public class QuickStartApplication {

    public static void main(String[] args) {
        /* 运行SpringBoot应用 */
        SpringApplication.run(QuickStartApplication.class, args);
    }

}
