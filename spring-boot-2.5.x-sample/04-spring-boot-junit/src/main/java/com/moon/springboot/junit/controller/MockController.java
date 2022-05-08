package com.moon.springboot.junit.controller;

import com.moon.springboot.junit.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于 web 环境模拟测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-20 22:41
 * @description
 */
@RestController
@RequestMapping("/books")
public class MockController {

    @GetMapping("msg")
    public String getMsg() {
        System.out.println("getMsg is running .....");
        return "book msg";
    }

    @GetMapping("info")
    public Book getBookInfo() {
        System.out.println("getBookInfo is running .....");

        Book book = new Book();
        book.setId(1);
        book.setName("Spring Boot 快速入门");
        book.setType("计算机");
        book.setDescription("这是一本好书");

        return book;
    }

}
