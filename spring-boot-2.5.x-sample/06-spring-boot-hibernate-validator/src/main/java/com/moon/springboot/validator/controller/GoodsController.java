package com.moon.springboot.validator.controller;

import com.moon.springboot.validator.bean.GoodsDTO;
import com.moon.springboot.validator.groups.Create;
import com.moon.springboot.validator.groups.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试请求控制器，分组校验测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-07-20 14:55
 * @description
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    /**
     * 新增分组校验
     */
    @PostMapping("/create")
    public String create(@RequestBody @Validated(Create.class) GoodsDTO goodsDTO) {
        System.out.println("新增分组校验...");
        return "新增分组校验 success";
    }

    /**
     * 更新分组校验
     */
    @PostMapping("/update")
    public String update(@RequestBody @Validated(Update.class) GoodsDTO goodsDTO) {
        System.out.println("更新分组校验...");
        return "更新分组校验 success";
    }

}
