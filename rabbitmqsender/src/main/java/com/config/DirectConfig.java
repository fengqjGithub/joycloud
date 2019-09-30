package com.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project: joycloud
 * @Package: com.config
 * @Author: 冯前进
 * @Date: 2019-09-12 17:16
 * @Description: TODO
 **/
@Configuration
public class DirectConfig {

    /**
     * Direct模式
     *
     * @return
     */
    @Bean(name = "queue")
    public Queue queue() {
        return new Queue("testQueue");
    }

    @Bean(name = "queue2")
    public Queue queue2() {
        return new Queue("testQueue2");
    }

//    @Bean(name = "diushiQueue")
//    public Queue diushiQueue() {
//        return new Queue("diushiQueue");
//    }
}
