package com.moon.springbootstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制类
 *
 * @author MoonZero
 * @version 1.0
 * @date 2020-3-8 18:15
 * @description
 */
@RestController
public class DemoController {

    @RequestMapping("/")
    String index() {
        return "Hello, spring boot!";
    }

}
