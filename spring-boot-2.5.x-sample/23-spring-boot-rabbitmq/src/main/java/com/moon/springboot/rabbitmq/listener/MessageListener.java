package com.moon.springboot.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费监听器
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-02 17:29
 * @description
 */
@Component
public class MessageListener {

    /*
     * @RabbitListener 注解用于标识方法，通过 queues 属性指定监听的列队名称
     * 当该队列出现消息后，此方法就会被调用，方法形参为接收消息的内容
     */
    @RabbitListener(queues = "direct_queue")
    public void receive(String id) {
        System.out.println("direct_queue 队列已完成短信发送业务，id：" + id);
    }

    // 如果定义多个监听同一个队列，那么 RabbitMQ 会以轮询的方式让每个消费者平均消费消息
    @RabbitListener(queues = "direct_queue")
    public void receive2(String id) {
        System.out.println("direct_queue 队列2已完成短信发送业务，id：" + id);
    }

}
