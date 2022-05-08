package com.moon.springboot.admin.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Health 端点配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-07 11:15
 * @description
 */
@Configuration
public class HealthConfig extends AbstractHealthIndicator {

    /**
     * 设置 Health 端点信息
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 模拟一些业务或者故障判断
        boolean condition = System.currentTimeMillis() % 2 == 0;
        if (condition) {
            builder.status(Status.UP);// 设置运行状态为启动状态
            // 配置单个信息
            builder.withDetail("runTime", System.currentTimeMillis());
            // 使用 Map 配置多个信息
            Map<String, Object> infoMap = new HashMap<>();
            infoMap.put("description", "我是健康的一段描述");
            infoMap.put("why error", "如果当前系统时间是奇数，则服务正常");
            builder.withDetails(infoMap);
        } else {
            builder.status(Status.OUT_OF_SERVICE); // 设置运行状态为不在服务状态
            builder.withDetail("why error", "如果当前系统时间是偶数，则不在服务服务状态");
        }
    }

}
