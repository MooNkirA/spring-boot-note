package com.moon.springboot.configuration;

import com.moon.springboot.configuration.bean.CatBean;
import com.moon.springboot.configuration.bean.CompanyBean;
import com.moon.springboot.configuration.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * 启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-12 13:58
 * @description
 */
@SpringBootApplication
/*
 * 注意：
 *  使用 @ConfigurationProperties 注解进行配置和实体映射，需要该 bean 给 Spring 管理才能生效。有以下两种方式实现：
 *   方式1：使用 @Component 注解标识该类
 *   方式2：在配置类中使用 @EnableConfigurationProperties 指定该类
 */
@EnableConfigurationProperties({CompanyBean.class, CatBean.class, ServerConfig.class})
// 通过 @PropertySource 注解手动导入 properties 文件，测试使用 @ConfigurationProperties 注解进行配置和实体映射
@PropertySource("classpath:cat.properties")
public class ConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }

}
