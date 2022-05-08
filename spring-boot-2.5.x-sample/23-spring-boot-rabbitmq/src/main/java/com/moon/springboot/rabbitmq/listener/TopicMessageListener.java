package com.moon.springboot.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 测试主题类型消息监听器
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-03 23:27
 * @description
 */
@Component
public class TopicMessageListener {

    /*
     * @RabbitListener 注解用于标识方法，通过 queues 属性指定监听的列队名称
     * 当该队列出现消息后，此方法就会被调用，方法形参为接收消息的内容
     */
    @RabbitListener(queues = "topic_queue")
    public void receive(String id) {
        System.out.println("topic_queue 队列 已完成短信发送业务，id：" + id);
    }

    // 监听同一个交换机绑定的不同的队列
    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id) {
        System.out.println("topic_queue 队列 2 已完成短信发送业务，id：" + id);
    }

}
