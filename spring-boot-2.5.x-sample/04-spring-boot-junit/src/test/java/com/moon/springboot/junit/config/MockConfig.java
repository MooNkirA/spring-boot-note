package com.moon.springboot.junit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 模拟通过配置类创建一些测试需要的 bean 对象
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-20 22:12
 * @description
 */
@Configuration
public class MockConfig {

    // 此处为了不引入其他第三方 jar 包，直接创建一个 String 对象用来测试
    @Bean
    public String mock() {
        return "mock bean";
    }

}
