package com.moon.springboot.kafka.service;

/**
 * 业务接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-02 16:39
 * @description
 */
public interface MessageService {

    // 发送消息
    void sendMessage(String id);

}
