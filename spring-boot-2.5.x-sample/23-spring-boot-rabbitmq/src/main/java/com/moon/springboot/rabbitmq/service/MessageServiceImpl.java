package com.moon.springboot.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务实现
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-02 16:40
 * @description
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("接收到 id：" + id + " 的订单，准备给用户发送短信通知...");
        /*
         * 调用 AmqpTemplate.convertAndSend(String exchange, String routingKey, final Object object) 方法，
         * 向 RabbitMQ 服务发送消息，该方法直接将内容进行转换后，再发送
         *      exchange 参数：指定消息发送到哪个交换机的名称
         *      routingKey 参数：指定消息发送到交换机与队列绑定的路由名称
         *      object 参数：发送的消息体内容
         */
        amqpTemplate.convertAndSend("directExchange","direct", id);
    }

}
