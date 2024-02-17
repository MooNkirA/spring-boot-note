package com.moon.springboot.routingdatasource.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 多数据源配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-02-15 13:42
 * @description
 */
@Configuration
public class MasterSlaveDataSourceConfiguration {

    @Bean
    public DataSource dataSource(MasterSlaveDataSourceProperties properties) {
        MasterSlaveDataSource dataSource = new MasterSlaveDataSource();

        // 设置主数据库
        dataSource.setDefaultTargetDataSource(new HikariDataSource(new HikariConfig(properties.master())));
        // 从数据库
        Map<Object, Object> slaveDataSource = new HashMap<>();

        // 设置从数据库 Key
        dataSource.setSlaveKeys(new ArrayList<>());

        for (Map.Entry<String, Properties> entry : properties.slave().entrySet()) {
            if (slaveDataSource.containsKey(entry.getKey())) {
                throw new IllegalArgumentException("存在同名的从数据库定义：" + entry.getKey());
            }

            slaveDataSource.put(entry.getKey(), new HikariDataSource(new HikariConfig(entry.getValue())));
            dataSource.getSlaveKeys().add(entry.getKey());
        }

        // 设置从库
        dataSource.setTargetDataSources(slaveDataSource);
        return dataSource;
    }

}
