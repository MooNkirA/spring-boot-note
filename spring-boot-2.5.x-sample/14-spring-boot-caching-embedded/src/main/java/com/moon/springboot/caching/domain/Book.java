package com.moon.springboot.caching.domain;

import lombok.Data;

/**
 * 表实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 22:27
 * @description
 */
@Data
public class Book {

    private Integer id;
    private String type;
    private String name;
    private String description;

}
