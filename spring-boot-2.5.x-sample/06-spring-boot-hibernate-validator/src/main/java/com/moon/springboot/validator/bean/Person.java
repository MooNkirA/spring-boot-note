package com.moon.springboot.validator.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 配置数据绑定校验测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-17 21:54
 * @description
 */
@Data
@Configuration
@ConfigurationProperties("person")
@Validated // 开启对当前 bean的 属性注入校验
public class Person {

    // 设置具体的检验规则
    @NotBlank(message = "名称不能为空")
    @Length(min = 3, max = 10, message = "名称的长度不合法")
    private String name;
    @Range(min = 12, max = 60, message = "年龄不合法")
    private Integer age;
    @Email(message = "邮箱地址不合法")
    private String email;

}
