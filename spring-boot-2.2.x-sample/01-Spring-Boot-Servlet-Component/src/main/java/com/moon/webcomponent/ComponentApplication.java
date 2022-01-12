package com.moon.webcomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Spring Boot 整合 Servlet、Filter、Listener 启动类
 *
 * @author MoonZero
 * @version 1.0
 * @date 2020-3-15 12:00
 * @description
 */
@SpringBootApplication
// @ServletComponentScan 注解作用是扫描指定包中有@WebServlet、@WebFilter、@WebListener等注解的类
@ServletComponentScan(basePackages = {"com.moon.webcomponent"})
public class ComponentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentApplication.class, args);
    }

}
