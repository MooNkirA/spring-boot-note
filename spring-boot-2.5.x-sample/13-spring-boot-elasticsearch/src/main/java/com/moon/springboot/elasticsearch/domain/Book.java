package com.moon.springboot.elasticsearch.domain;

import lombok.Data;

/**
 * 文档相应的实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 14:16
 * @description
 */
@Data
public class Book {

    private Integer id;
    private String type;
    private String name;
    private String description;

}