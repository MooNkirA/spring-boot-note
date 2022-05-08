package com.moon.springboot.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
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
     * @JmsListener 注解用于标识方法，通过 destination 属性指定监听的列队名称
     * 当该队列出现消息后，此方法就会被调用，方法形参为接收消息的内容
     */
    @JmsListener(destination = "order.queue.id")
    /*
     * @SendTo 注解用于当前方法消费后，将消息转发到下一个消息队列中，注解属性指定下一个队列的名称。
     * 注意：方法必须有返回值，返回的内容就是转发到下一个队列的消息内容
     */
    @SendTo("order.queue.otherId")
    public String receive(String id) {
        System.out.println("已完成短信发送业务，id：" + id);
        // 返回新的消息内容
        return "new ID: " + id;
    }

}
