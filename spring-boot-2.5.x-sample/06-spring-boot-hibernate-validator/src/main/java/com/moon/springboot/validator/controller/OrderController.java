package com.moon.springboot.validator.controller;

import com.moon.springboot.validator.bean.OrderDTO;
import com.moon.springboot.validator.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Service 层方法参数校验
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-07-14 10:29
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 更新操作，校验对象类型参数
     */
    @PostMapping("/update")
    public String update(@RequestBody OrderDTO orderDTO) {
        return orderService.update(orderDTO);
    }

    /**
     * 查询，校验普通类型参数
     */
    @GetMapping("/get")
    public String getOrder(String orderId, String status) {
        return orderService.getOrder(orderId, status);
    }

}
