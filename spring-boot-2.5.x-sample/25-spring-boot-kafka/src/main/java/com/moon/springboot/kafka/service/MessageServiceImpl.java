package com.moon.springboot.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("接收到 id：" + id + " 的订单，准备给用户发送短信通知...");
        /*
         * 调用 JmsMessagingTemplate.send(String topic, @Nullable V data) 方法，向 Kafka 服务发送消息
         *      topic 参数：消息发往的主题名称
         *      data 参数：发送的消息体内容
         */
        kafkaTemplate.send("spring.kafka", id);
    }

}
