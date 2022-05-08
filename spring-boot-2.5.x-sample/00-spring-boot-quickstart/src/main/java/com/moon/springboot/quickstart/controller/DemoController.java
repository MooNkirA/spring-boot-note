package com.moon.springboot.quickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制类
 *
 * @author MoonZero
 * @version 1.0
 * @date 2022-1-12 11:41
 * @description
 */
@RestController
public class DemoController {

    @RequestMapping("/")
    public String index() {
        return "Hello, spring boot!";
    }

}
