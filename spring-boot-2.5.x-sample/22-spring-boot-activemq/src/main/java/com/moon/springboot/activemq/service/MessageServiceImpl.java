package com.moon.springboot.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
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
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("接收到 id：" + id + " 的订单，准备给用户发送短信通知...");
        /*
         * 调用 JmsMessagingTemplate.convertAndSend(String destinationName, Object payload) 方法，向 ActiveMQ 服务发送消息
         * 该方法直接将内容进行转换后，再发送
         *      destinationName 参数：消息发往的队列名称
         *      payload 参数：发送的消息体内容
         */
        messagingTemplate.convertAndSend("order.queue.id", id);
    }

}
