package com.rabbitmqreceiver.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Project: joycloud
 * @Package: com.rabbitmqreceiver.config
 * @Author: 冯前进
 * @Date: 2019-09-30 9:07
 * @Description: TODO
 **/
@Component
public class DirectConfig {
    @Bean(name = "diushiQueue")
    public Queue diushiQueue() {
        return new Queue("diushiQueue");
    }
}
