package com.moon.springboot.admin.controller;

import com.moon.springboot.admin.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例请求
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-07 13:57
 * @description
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public String query() {
        return demoService.query();
    }

}
