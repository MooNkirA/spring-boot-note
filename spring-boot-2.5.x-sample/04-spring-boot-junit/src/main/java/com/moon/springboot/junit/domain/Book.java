package com.moon.springboot.junit.domain;

/**
 * 实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-20 22:43
 * @description
 */
public class Book {

    private int id;
    private String name;
    private String type;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
