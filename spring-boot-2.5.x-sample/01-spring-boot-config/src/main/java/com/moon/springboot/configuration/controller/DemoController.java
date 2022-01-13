package com.moon.springboot.configuration.controller;

import com.moon.springboot.configuration.bean.CatBean;
import com.moon.springboot.configuration.bean.CompanyBean;
import com.moon.springboot.configuration.bean.ValueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试 Spring Boot 配置的读取
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-12 14:38
 * @description
 */
@RestController
@RequestMapping("config")
public class DemoController {

    @Autowired
    private ValueBean valueBean;

    @Autowired
    private Environment environment;

    @Autowired
    private CompanyBean companyBean;

    @Autowired
    private CatBean catBean;

    // 通过 @Value 注解方式读取配置文件
    @GetMapping("value")
    public ValueBean readByValueAnnotation() {
        return valueBean;
    }

    // 通过 Environment 对象读取配置文件
    @GetMapping("env")
    public Map<String, Object> readByEnvironment() {
        Map<String, Object> map = new HashMap<>();
        // 读取普通类型
        String name = environment.getProperty("name");
        map.put("name", name);
        // 读取数组，第2个元素
        String city = environment.getProperty("city[1]");
        map.put("city", city);
        // 读取对象类型数组，第3个对象元素的 score 属性
        String score = environment.getProperty("student[2].score");
        map.put("score", score);
        // 读取复杂对象类型，subject 属性数组的第1个元素
        String subject = environment.getProperty("company.subject[0]");
        map.put("subject", subject);
        // 一样可以读取 properties 文件的属性值
        String port = environment.getProperty("custom.port");
        map.put("port", port);

        return map;
    }

    // 通过 @ConfigurationPropertiesBean 注解方式进行配置与实体映射读取
    @GetMapping("config-properties")
    public CompanyBean readByConfigurationProperties() {
        return companyBean;
    }

    // 通过 @PropertySource 导入 propertiees 配置，并使用 @ConfigurationPropertiesBean 注解方式进行配置与实体映射读取
    @GetMapping("config-properties2")
    public CatBean readByConfigurationPropertiesPropertySource() {
        return catBean;
    }

}
