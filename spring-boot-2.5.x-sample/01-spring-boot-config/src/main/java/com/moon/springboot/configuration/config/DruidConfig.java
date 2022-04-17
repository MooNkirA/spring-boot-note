package com.moon.springboot.configuration.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Druid 配置类，用于测试 @ConfigurationProperties 给第三方 jar 包对象属性绑定值
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-17 8:44
 * @description
 */
@Configuration
public class DruidConfig {

    /* 1. 使用 @Bean 注解创建第三方 bean 实例 */
    @Bean
    /* 2. 使用 @ConfigurationProperties 注解标识在创建第三方 bean 实例的方法，进行属性绑定，注意前缀是全小写的 datasource */
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource datasource() {
        return new DruidDataSource();
    }

}
