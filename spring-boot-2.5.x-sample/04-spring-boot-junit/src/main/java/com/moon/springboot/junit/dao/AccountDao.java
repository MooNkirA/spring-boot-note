package com.moon.springboot.junit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moon.springboot.junit.domain.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * 持久层接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-22 21:36
 * @description
 */
@Mapper
public interface AccountDao extends BaseMapper<Account> {
}
