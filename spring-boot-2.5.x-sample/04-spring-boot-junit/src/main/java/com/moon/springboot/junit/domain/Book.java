package com.moon.springboot.junit.domain;

import lombok.Data;

/**
 * 实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-20 22:43
 * @description
 */
@Data
public class Book {

    private int id;
    private String name;
    private String type;
    private String description;

}
