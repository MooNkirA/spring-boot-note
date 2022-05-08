package com.moon.springboot.junit.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Junit 整合测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-01-13 14:17
 * @description
 */
@SpringBootTest
public class JunitTest {

    @Test
    public void testBasic() {
        System.out.println("spring boot 整合 junit 基础测试....");
    }

}
