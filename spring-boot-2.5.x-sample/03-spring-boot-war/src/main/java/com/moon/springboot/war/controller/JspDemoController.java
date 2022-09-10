package com.moon.springboot.war.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JSP 视图测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-06-10 18:38
 * @description
 */
@Controller
public class JspDemoController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("进入了控制器");
        return "hello"; // 返回 jsp 名称
    }

}
