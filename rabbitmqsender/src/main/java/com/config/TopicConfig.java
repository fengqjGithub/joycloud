package com.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project: joycloud
 * @Package: com.config
 * @Author: 冯前进
 * @Date: 2019-09-17 15:16
 * @Description: TODO
 **/
@Configuration
public class TopicConfig {
    /**
     * Topic转发模式
     */
    //只接一个topic
    private final static String message = "topic.message";
    //接收多个topic
    private final static String messages = "topic.messages";

    private final static String exchange = "exchange";

    @Bean(name = "queueMessage")
    public Queue queueMessage() {
        return new Queue(message);
    }

    @Bean(name = "queueMessages")
    public Queue queueMessages() {
        return new Queue(messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("queueMessage") Queue queueMessage2, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("queueMessages") Queue queueMessages2, TopicExchange exchange) {
        //这里的#表示零个或多个词。
        return BindingBuilder.bind(queueMessages2).to(exchange).with("topic.#");
    }

}
