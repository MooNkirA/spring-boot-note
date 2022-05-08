package com.moon.springboot.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-01 16:07
 * @description
 */
@SpringBootApplication
@EnableScheduling // 开启定时任务功能
public class TaskSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskSchedulingApplication.class, args);
    }

}
