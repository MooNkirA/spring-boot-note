package com.moon.springboot.multiconfig.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * 测试多配置文件
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-13 8:45
 * @description
 */
// properties 属性用于在测试时指定一些配置参数值，下例就是指定配置文件中 ACTIVE_NAME 变量的值为 dev
@SpringBootTest(properties = {"ACTIVE_NAME=dev"})
public class MultiConfigTest {

    @Autowired
    private Environment environment;

    @Test
    public void testActiveProfiles() {
        String[] activeProfiles = environment.getActiveProfiles();
        for (String profile : activeProfiles) {
            System.out.printf("当前激活的profiles是：%s", profile);
        }
        String port = environment.getProperty("server.port");
        System.out.printf("当前项目的端口：%s", port);
    }

}
