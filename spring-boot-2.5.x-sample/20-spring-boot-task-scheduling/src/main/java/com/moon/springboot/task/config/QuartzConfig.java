package com.moon.springboot.task.config;

import com.moon.springboot.task.job.MyQuartzJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz 配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-01 16:22
 * @description
 */
@Configuration
public class QuartzConfig {

    /**
     * 创建 JobDetail 工作明细实例
     *
     * @return
     */
    @Bean
    public JobDetail createJobDetail() {
        // 绑定具体的任务类
        return JobBuilder.newJob(MyQuartzJob.class)
                .storeDurably()
                .build();
    }

    /**
     * 创建 Trigger 任务触发器实例
     *
     * @return
     */
    @Bean
    public Trigger createJobTrigger() {
        // 使用 cron 表达式定义执行规则
        ScheduleBuilder<CronTrigger> schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        // 绑定对应的工作明细对象
        return TriggerBuilder.newTrigger().forJob(createJobDetail())
                .withSchedule(schedBuilder).build();
    }

}
