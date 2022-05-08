package com.moon.springboot.rocketmq.service;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
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
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("接收到 id：" + id + " 的订单，准备给用户发送短信通知...");
        /*
         * RocketMQTemplate 也有 convertAndSend(D destination, Object payload) 方法向 RocketMQ 服务发送消息，但该方法是同步方法
         * 通常会使用 RocketMQTemplate.asyncSend(String destination, Object payload, SendCallback sendCallback) 方法，向 RocketMQ 服务发送异常消息
         *      destinationName 参数：消息发往的目的地名称
         *      payload 参数：发送的消息体内容
         *      sendCallback 参数：消息发送成功/失败后的回调方法
         */
        rocketMQTemplate.asyncSend("order_id", id, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功！");
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("消息发送失败！！");
            }
        });
    }

}
