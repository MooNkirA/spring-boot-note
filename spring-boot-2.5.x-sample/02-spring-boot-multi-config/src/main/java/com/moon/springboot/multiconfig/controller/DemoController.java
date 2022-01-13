package com.moon.springboot.multiconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 多配置文件测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-12 21:56
 * @description
 */
@RestController
@RequestMapping("multi-config")
public class DemoController {

    @GetMapping("profiles")
    public Map<String, Object> activeProfiles() {
        return null;
    }

}
