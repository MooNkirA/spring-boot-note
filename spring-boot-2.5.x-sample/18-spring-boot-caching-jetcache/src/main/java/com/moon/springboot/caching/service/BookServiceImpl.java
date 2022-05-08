package com.moon.springboot.caching.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.moon.springboot.caching.domain.Book;
import com.moon.springboot.caching.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @Cached 注解标识的方法代表该方法使用缓存功能
     *      name 属性：缓存键的前缀名称
     *      key 属性：缓存键的取值
     *      expire 属性：缓存键的过期时间，单位默认是秒
     *      cacheType 属性：缓存的类型，是远程、本地或者两者均使用
     */
    @Cached(name = "book_", key = "#id", expire = 60, cacheType = CacheType.REMOTE)
    // @CacheRefresh(refresh = 5) // 定时刷新缓存，refresh 属性指定刷新的间隔时间，单位默认是秒
    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    /*
     * @CacheUpdate 注解用于更新缓存
     *      name 属性：缓存键的前缀名称
     *      key 属性：缓存键的取值
     *      value 属性：更新的值
     */
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    @Override
    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    /*
     * @CacheInvalidate 注解用于删除缓存
     *      name 属性：缓存键的前缀名称
     *      key 属性：缓存键的取值
     */
    @CacheInvalidate(name = "book_", key = "#id")
    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

}
