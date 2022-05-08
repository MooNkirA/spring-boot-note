package com.moon.springboot.mongodb.domain;

import lombok.Data;

/**
 * 数据实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-27 16:30
 * @description
 */
@Data
public class Book {

    private int id;
    private String name;
    private String type;
    private String description;

}

