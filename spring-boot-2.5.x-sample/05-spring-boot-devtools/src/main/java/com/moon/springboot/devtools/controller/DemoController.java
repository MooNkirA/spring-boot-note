package com.moon.springboot.devtools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-boot-devtools 热部署测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-14 20:20
 * @description
 */
@RestController
@RequestMapping("devtools")
public class DemoController {

    @GetMapping("test")
    public String basicTest() {
        return "devtools 热部署测试!!!!!";
    }

}
