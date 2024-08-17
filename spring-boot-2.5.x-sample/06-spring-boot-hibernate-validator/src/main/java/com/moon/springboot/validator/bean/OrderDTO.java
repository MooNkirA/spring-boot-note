package com.moon.springboot.validator.bean;

import com.moon.springboot.validator.annotation.IdCard;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 订单对象，用于测试 Service 层对象参数校验
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-07-14 11:21
 * @description
 */
@Data
public class OrderDTO {

    @NotBlank(message = "订单不能为空")
    private String orderId;
    @IdCard(message = "用户信息有误,请核对后提交")
    private String customerId;
    private String customerName;

}
