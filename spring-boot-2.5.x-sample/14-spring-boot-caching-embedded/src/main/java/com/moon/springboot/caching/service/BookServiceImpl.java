package com.moon.springboot.caching.service;

import com.moon.springboot.caching.domain.Book;
import com.moon.springboot.caching.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 业务接口实现
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 22:30
 * @description
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    /*
     * @Cacheable 用于标识当前方法，将返回保存到缓存中
     *  value 属性：缓存存储的位置（存储空间名称）
     *  key 属性：方法返回结果保存的缓存名称。
     */
    @Cacheable(value = "dbDataCache", key = "#id")
    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

}
