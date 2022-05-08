package com.moon.springboot.junit.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置随机值的机制测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-22 22:18
 * @description
 */
@Component
@Data
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {

    private int id;
    private int id2;
    private int type;
    private String name;
    private String uuid;
    private long publishTime;

}
