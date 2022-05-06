package com.moon.springboot.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
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
     * @KafkaListener 注解用于标识方法，通过 topics 属性指定监听的主题名称
     * 当该主题的消息队列出现消息后，此方法就会被调用，方法形参为接收消息的内容
     * 消息会包装在 ConsumerRecord<K, V> 对象
     */
    @KafkaListener(topics = "spring.kafka")
    public void receive(ConsumerRecord<String, String> record) {
        System.out.println("已完成短信发送业务，id：" + record.value());
    }

}
