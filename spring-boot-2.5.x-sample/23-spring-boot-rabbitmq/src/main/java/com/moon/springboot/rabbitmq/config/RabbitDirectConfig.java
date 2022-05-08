package com.moon.springboot.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 直连消息模式的配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-02 23:06
 * @description
 */
@Configuration
public class RabbitDirectConfig {

    /* 创建队列 */
    @Bean
    public Queue directQueue() {
        // 指定队列名称
        return new Queue("direct_queue");
    }

    /* 创建交换机 */
    @Bean
    public DirectExchange directExchange() {
        // 指定交换机名称
        return new DirectExchange("directExchange");
    }

    /* 创建 Binding 对象，绑定交换机与队列 */
    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }

    /* 以下表示可以创建多个队列，然后同一个交换机可以绑定多个队列 */
    @Bean
    public Queue directQueue2() {
        return new Queue("direct_queue2");
    }

    @Bean
    public Binding bindingDirect2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("direct2");
    }

}
