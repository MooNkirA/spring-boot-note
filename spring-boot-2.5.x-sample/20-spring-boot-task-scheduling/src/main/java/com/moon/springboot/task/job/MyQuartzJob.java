package com.moon.springboot.task.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Quartz 任务实现类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-01 16:13
 * @description
 */
public class MyQuartzJob extends QuartzJobBean {

    /**
     * 任务执行的核心方法
     *
     * @param context
     * @see #execute
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("MyQuartzJob task run...");
    }

}
