package com.moon.springboot.activemq.contorller;

import com.moon.springboot.activemq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例请求接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-02 16:35
 * @description
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private MessageService messageService;

    @GetMapping("{id}")
    public String updateOrder(@PathVariable String id) throws InterruptedException {
        // 模拟调用了N个服务接口，处理很复杂的业务逻辑
        System.out.println("系统很忙碌地处理 id 为：" + id + " 的订单....");
        messageService.sendMessage(id); // 发送消息
        Thread.sleep(2000); // 模拟业务处理时间
        return "success";
    }

}
