package com.moon.springboot.junit.test;

import com.moon.springboot.junit.config.MockConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * 加载测试专用配置类测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-20 22:11
 * @description
 */
@SpringBootTest
@Import({MockConfig.class})
public class ImportConfigTest {

    @Autowired
    private String msg;

    @Test
    void testConfiguration(){
        System.out.println(msg);
    }
}
