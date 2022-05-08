package com.moon.springboot.h2.domain;

import lombok.Data;

/**
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-24 15:59
 * @description
 */
@Data
public class User {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
}
