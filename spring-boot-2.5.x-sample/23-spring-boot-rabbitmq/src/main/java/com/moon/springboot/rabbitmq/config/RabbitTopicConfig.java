package com.moon.springboot.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主题模式消息配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-03 22:13
 * @description
 */
@Configuration
public class RabbitTopicConfig {

    /* 创建队列1 */
    @Bean
    public Queue topicQueue() {
        // 指定队列名称
        return new Queue("topic_queue");
    }

    /* 以下表示可以创建多个队列，然后同一个交换机可以绑定多个队列 */
    @Bean
    public Queue topicQueue2() {
        return new Queue("topic_queue2");
    }

    /* 创建主题类型交换机 */
    @Bean
    public TopicExchange topicExchange() {
        // 指定主题类型交换机名称
        return new TopicExchange("topicExchange");
    }

    /* 创建 Binding 对象，绑定主题类型交换机与队列 */
    @Bean
    public Binding bindingtopic() {
        // 主题模式支持 routingKey 匹配模式。（* 表示匹配一个单词，# 表示匹配任意内容）
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }

    /* 创建另一个 Binding 对象，绑定主题类型交换机与队列2 */
    @Bean
    public Binding bindingtopic2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.orders.*");
    }

}
