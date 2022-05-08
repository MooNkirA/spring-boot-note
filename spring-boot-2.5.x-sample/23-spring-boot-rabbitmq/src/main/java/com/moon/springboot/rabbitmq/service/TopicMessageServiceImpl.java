package com.moon.springboot.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 主题类型消息测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-03 22:56
 * @description
 */
@Service
public class TopicMessageServiceImpl implements TopicMessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("接收到 id：" + id + " 的订单，rabbitmq topic 类型准备给用户发送短信通知...");
        /*
         * 调用 AmqpTemplate.convertAndSend(String exchange, String routingKey, final Object object) 方法，
         * 向 RabbitMQ 服务发送消息，该方法直接将内容进行转换后，再发送
         *      exchange 参数：指定消息发送到哪个交换机的名称
         *      routingKey 参数：指定消息发送到交换机与队列绑定的路由名称
         *      object 参数：发送的消息体内容
         */
        // 选择主题类型交换机，根据不同的 routingKey 匹配发送到哪些队列中
        amqpTemplate.convertAndSend("topicExchange", "topic.orders.id", id);
    }

}
