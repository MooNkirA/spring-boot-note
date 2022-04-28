package com.moon.springboot.mongodb.test;

import com.moon.springboot.mongodb.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * MongoTemplate 操作 MongoDB 基础使用测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-27 16:31
 * @description
 */
@SpringBootTest
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testSave() {
        Book book = new Book();
        book.setId(2);
        book.setName("好好学习");
        book.setType("杂谈");
        book.setDescription("这是一本好书");

        mongoTemplate.save(book);
    }

    @Test
    public void testFindAll() {
        List<Book> books = mongoTemplate.findAll(Book.class);
        System.out.println(books);
    }

}
