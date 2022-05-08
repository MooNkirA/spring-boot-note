package com.moon.springboot.configuration.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 使用 @ConfigurationProperties 注解，将 yml 配置与实体进行映射
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-12 15:15
 * @description
 */
// @Component // 注意：需要标识给Spring管理，@ConfigurationProperties 注解才能进行配置和实体映射。（或者在配置类中使用 @EnableConfigurationProperties 指定）
/*
 * 通过注解 @ConfigurationProperties() 可以将配置文件中的配置自动与实体进行映射
 * prefix="配置文件中的key的前缀"：用来选择属性的前缀，也就是在配置文件中的“company”以下的属性
 * ignoreUnknownFields 是用来告诉 SpringBoot 在有属性不能匹配到声明的域时抛出异常
 */
@ConfigurationProperties(prefix = "company", ignoreUnknownFields = false)
@Data
public class CompanyBean {

    private String name;
    private String tel;
    private String email;
    private String[] subject;

}
