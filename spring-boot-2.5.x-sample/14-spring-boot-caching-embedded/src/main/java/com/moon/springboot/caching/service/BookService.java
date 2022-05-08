package com.moon.springboot.caching.service;

import com.moon.springboot.caching.domain.Book;

/**
 * 业务接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 22:28
 * @description
 */
public interface BookService {

    Book getById(Integer id);

}
