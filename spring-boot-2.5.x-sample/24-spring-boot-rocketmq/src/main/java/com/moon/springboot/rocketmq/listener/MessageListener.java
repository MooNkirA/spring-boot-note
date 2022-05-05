package com.moon.springboot.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
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
// @RocketMQMessageListener 注解用于定义监听的消息队列的名称，与消息所属的分组
@RocketMQMessageListener(topic = "order_id", consumerGroup = "group_rocketmq")
// RocketMQ 的监听器规定必须实现 org.apache.rocketmq.spring.core.RocketMQListener 接口，泛型为消息的数据类型
public class MessageListener implements RocketMQListener<String> {

    /**
     * 在监听到相关主题的出现消息时，此方法会被调用，方法形参为接收消息的内容
     *
     * @param message 传递的消息内容
     */
    @Override
    public void onMessage(String message) {
        System.out.println("rocketmq 已完成短信发送业务，id：" + message);
    }

}
