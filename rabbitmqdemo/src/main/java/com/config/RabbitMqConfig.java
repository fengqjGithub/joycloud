package com.config;

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
public class RabbitMqConfig {

   @Bean
    public Queue queue(){
       return new Queue("testQueue");
   }
    @Bean
    public Queue queue2(){
        return new Queue("testQueue2");
    }
}
