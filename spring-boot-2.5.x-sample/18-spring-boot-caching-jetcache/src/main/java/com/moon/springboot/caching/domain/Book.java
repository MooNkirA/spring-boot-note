package com.moon.springboot.caching.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 表实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 22:27
 * @description
 */
@Data
public class Book implements Serializable {
    private static final long serialVersionUID = -4164642965841619064L;

    private Integer id;
    private String type;
    private String name;
    private String description;

}
