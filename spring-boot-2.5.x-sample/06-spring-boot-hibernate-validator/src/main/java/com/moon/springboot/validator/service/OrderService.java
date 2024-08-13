package com.moon.springboot.validator.service;

import com.moon.springboot.validator.bean.OrderDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * 测试 Service 层方法参数校验
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-07-14 10:56
 * @description
 */
public interface OrderService {

    String getOrder(@NotBlank(message = "订单id不能为空") String orderId, String status);

    String update(@Valid OrderDTO orderDTO);

}
