package com.moon.springboot.junit.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * properties 临时属性、args 临时的命令行测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-18 23:08
 * @description
 */
/*
 * properties 属性可以为当前测试用例添加临时的属性配置
 *  与 value 属性一样的作用，如果没有其他属性，则可以省略不写 "value="
 */
// @SpringBootTest("test.prop=testValue1")
// 或者
// @SpringBootTest(properties = "test.message=testValueInProperties")
/* args属性可以为当前测试用例添加临时的命令行参数 */
// @SpringBootTest(args={"--test.message=testValueInArgs"})
/*
 * 如果同时设置 properties 与 args 属性，则由 spring boot 规定的属性加载优先级来决定
 *  所以最终会加载 args 属性的设置
 */
@SpringBootTest(properties = {"test.message=testValueInProperties"}, args = {"--test.message=testValueInArgs"})
public class PropertiesAndArgsTest {

    @Value("${test.message}")
    private String message;

    @Test
    public void testProperties() {
        System.out.println(message);
    }

}
