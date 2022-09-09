package com.moon.springboot.tomcat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试使用的控制器
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-06-13 15:02
 * @description
 */
@RestController
public class DemoController {

    @GetMapping("hello2")
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("hello2", "hello, spring!");
        return map;
    }

}
