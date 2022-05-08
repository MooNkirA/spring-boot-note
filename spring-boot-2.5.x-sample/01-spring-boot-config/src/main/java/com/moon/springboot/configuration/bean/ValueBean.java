package com.moon.springboot.configuration.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用 Spring 的 @Value 注解读取单个配置
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-12 14:57
 * @description
 */
@Component
@Data
public class ValueBean {

    // 读取普通类型
    @Value("${name}")
    private String name;
    // 读取数组，第2个元素
    @Value("${city[1]}")
    private String city;
    // 读取对象类型数组，第3个对象元素的 score 属性
    @Value("${student[2].score}")
    private String score;
    // 读取复杂对象类型，subject 属性数组的第1个元素
    @Value("${company.subject[0]}")
    private String subject;
    // 读取 properties 文件的属性
    @Value("${custom.port}")
    private String port;

}
