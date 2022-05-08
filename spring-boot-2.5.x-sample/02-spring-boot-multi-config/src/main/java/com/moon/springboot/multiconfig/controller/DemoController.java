package com.moon.springboot.multiconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    @Autowired
    private Environment environment;

    @GetMapping("profiles")
    public Map<String, Object> activeProfiles() {
        Map<String, Object> map = new HashMap<>();
        map.put("当前激活的profiles", environment.getActiveProfiles());
        map.put("当前项目的端口", environment.getProperty("server.port"));
        return map;
    }

}
