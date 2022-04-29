package com.moon.springboot.caching.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moon.springboot.caching.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * book 表持久接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 22:28
 * @description
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
