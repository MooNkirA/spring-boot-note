package com.moon.springboot.junit.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 数据库表实体类，用于测试事务回滚
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-21 23:17
 * @description
 */
@Data
public class Account {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private BigDecimal money;

}
