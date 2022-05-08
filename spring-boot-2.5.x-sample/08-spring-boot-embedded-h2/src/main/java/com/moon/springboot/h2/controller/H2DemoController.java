package com.moon.springboot.h2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moon.springboot.h2.mapper.UserMapper;
import com.moon.springboot.h2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * H2 内置数据库测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-24 16:01
 * @description
 */
@RestController
@RequestMapping("h2demo")
public class H2DemoController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("allUser")
    public List<User> selectAllUser() {
        return userMapper.selectList(new QueryWrapper<>());
    }

}
