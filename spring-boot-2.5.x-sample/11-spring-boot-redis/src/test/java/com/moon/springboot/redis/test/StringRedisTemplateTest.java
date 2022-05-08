package com.moon.springboot.redis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * StringRedisTemplate 基础使用示例
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-26 22:12
 * @description
 */
@SpringBootTest
public class StringRedisTemplateTest {

    /*
     * StringRedisTemplate 模版操作对象，相当于 RedisTemplate<String, String>
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testSet() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("test:name", "MooN");
    }

    @Test
    public void testGet() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String age = ops.get("test:name");
        System.out.println(age);
    }

}
