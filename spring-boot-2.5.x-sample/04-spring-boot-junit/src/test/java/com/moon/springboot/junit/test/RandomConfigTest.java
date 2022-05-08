package com.moon.springboot.junit.test;

import com.moon.springboot.junit.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 随机值的机制测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-22 22:19
 * @description
 */
@SpringBootTest
public class RandomConfigTest {

    @Test
    public void testRandomConfig(@Autowired BookCase bookCase) {
        System.out.println(bookCase);
    }

}
