package com.moon.springboot.redis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * RedisTemplate 基础使用示例
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-26 21:53
 * @description
 */
@SpringBootTest
public class RedisTemplateTest {

    /*
     * 注入 Redis 模版操作对象 RedisTemplate<K, V>
     *  如果不指定 k 值，则默认是对象类型的key
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("test:age", 41);
    }

    @Test
    public void testGet() {
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("test:age");
        System.out.println(age);
    }

    @Test
    public void testHset() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("test:person", "name", "Moon");
    }

    @Test
    public void testHget() {
        HashOperations ops = redisTemplate.opsForHash();
        Object val = ops.get("test:person", "name");
        System.out.println(val);
    }

}
