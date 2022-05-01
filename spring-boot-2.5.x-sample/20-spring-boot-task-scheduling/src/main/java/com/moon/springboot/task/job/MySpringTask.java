package com.moon.springboot.task.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 自定义 Spring Task 任务实现
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-01 16:40
 * @description
 */
@Component
public class MySpringTask {

    /*
     * @Scheduled 注解用于标识任务调度时执行的方法，通过 cron 属性来定义任务执行的规则
     */
    @Scheduled(cron = "0/3 * * * * ?")
    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + " : spring task run...");
    }

}
