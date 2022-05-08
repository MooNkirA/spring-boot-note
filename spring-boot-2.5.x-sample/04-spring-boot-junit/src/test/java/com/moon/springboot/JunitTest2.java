package com.moon.springboot;

import com.moon.springboot.junit.JunitApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Junit 整合测试。
 * 测试类不在启动类所在的包及其子包下。
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-13 14:17
 * @description
 */
/*
 *  如果测试类不在启动类所在的包及其子包下。会报如下的错误：
 *  java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
 *  解决方法如下：
 *      1. 在 @SpringBootTest 注解中，通过 classes 属性指定启动类
 *      2. 添加 @ContextConfiguration 注解，通过 classes 属性指定启动类
 */
// @SpringBootTest(classes = {JunitApplication.class})
@SpringBootTest
@ContextConfiguration(classes = {JunitApplication.class})
public class JunitTest2 {

    @Test
    public void testBasic() {
        System.out.println("spring boot 整合 junit，测试类不在启动类所在的包及其子包下....");
    }

}
