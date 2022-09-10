package com.moon.springboot.validator.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义开启表单验证功能---快速失败返回模式的注解
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-07-20 16:54
 * @description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// 在启动类或者配置上标识此注解，就会导入快速失败返回模式的配置类 ValidatorConfiguration
// 从而实现自定是否需要开启此功能
@Import(ValidatorConfiguration.class)
public @interface EnableFormValidator {
}
