package com.moon.springboot.validator.service;

import com.moon.springboot.validator.bean.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 测试 Service 层方法参数校验
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-07-14 10:58
 * @description
 */
@Service
@Validated
public class OrderServiceImpl implements OrderService {

    @Override
    public String getOrder(String orderId, String status) {
        return String.format("成功获取订单号为【%s】，状态为【%s】", orderId, status);
    }

    @Override
    public String update(OrderDTO orderDTO) {
        return String.format("更新成功。订单号为【%s】，用户ID为【%s】", orderDTO.getOrderId(), orderDTO.getCustomerId());
    }

}
