package com.moon.springboot.validator.controller;

import com.moon.springboot.validator.annotation.IdCard;
import com.moon.springboot.validator.bean.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * 测试请求控制器
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-07-20 14:55
 * @description
 */
@RestController
@RequestMapping("/user")
@Validated  // 在当前类中开启 hibernate-validator 校验，类中所有标识了校验注解方法都都会进行校验
public class UserController {

    /**
     * 简单类型的校验
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@NotNull(message = "用户id不能为空") Integer id) {
        System.out.println("delete...");
        return "delete success";
    }

    /**
     * 对象属性校验
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    public String save(@RequestBody @Validated UserDTO user) {
        System.out.println("save...");
        return "save success";
    }

    /**
     * 自定义注解校验
     *
     * @param id
     * @return
     */
    @RequestMapping("/check")
    public String check(@IdCard(message = "身份证信息有误,请核对后提交") String id) {
        System.out.println("自定义注解校验...");
        return "自定义注解校验 success";
    }

}
