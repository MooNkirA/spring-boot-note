package com.moon.springboot.war.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Spring Boot 工程打包成 war 包
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-13 11:46
 * @description
 */
@RestController
public class DemoController {

    @GetMapping("demo")
    public String demoTest() {
        return "I am running on tomcat!";
    }

}
