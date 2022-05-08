package com.moon.springboot.configuration.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 使用 @ConfigurationProperties 注解，将 properties 配置与实体进行映射
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-12 15:15
 * @description
 */
// 通过注解 @ConfigurationProperties(prefix="配置文件中的key的前缀") 可以将配置文件中的配置自动与实体进行映射
@ConfigurationProperties("cat")
@Data
public class CatBean {

    private String name;
    private int age;
    private String color;

}
