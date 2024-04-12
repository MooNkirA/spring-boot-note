package com.moon.springboot.routingdatasource;

import com.moon.springboot.routingdatasource.config.MasterSlaveDataSourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AbstractRoutingDataSource 多数据源管理示例启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-02-15 12:56
 * @description
 */
@EnableConfigurationProperties(value = {MasterSlaveDataSourceProperties.class})
@EnableAspectJAutoProxy
@SpringBootApplication
public class RoutingDataSourceApp {

    public static void main(String[] args) {
        SpringApplication.run(RoutingDataSourceApp.class, args);
    }

}
