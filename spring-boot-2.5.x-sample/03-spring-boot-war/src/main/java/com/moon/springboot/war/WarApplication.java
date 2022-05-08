package com.moon.springboot.war;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-13 11:39
 * @description
 */
@SpringBootApplication
/*
 * 若将 Spring Boot 工程打包成 war 包，则需要继承 SpringBootServletInitializer 抽象类，
 * 并重写 configure 方法，此方法相当于 web.xml 的作用。
 *  注：此示例是直接让启动类继承 SpringBootServletInitializer，其实也可以单独创建一个类去继承 SpringBootServletInitializer，最终效果一样
 */
public class WarApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WarApplication.class, args);
    }

    /**
     * Configure the application. Normally all you would need to do is to add sources
     * (e.g. config classes) because other settings have sensible defaults. You might
     * choose (for instance) to add default command line arguments, or set an active
     * Spring profile.
     *
     * @param builder a builder for the application context
     * @return the application builder
     * @see SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        /* 设置启动类 */
        builder.sources(WarApplication.class);
        /* 设置横幅模式 */
        builder.bannerMode(Banner.Mode.OFF);
        /* 返回SpringBoot应用启动对象 */
        return super.configure(builder);
    }
}
