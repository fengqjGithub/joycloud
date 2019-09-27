package com.receicer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Project: joycloud
 * @Package: com.service
 * @Author: 冯前进
 * @Date: 2019-09-17 15:33
 * @Description: TODO
 **/
@Component
public class TopicReceiver {
    @RabbitListener(queues = "topic.message")
    @RabbitHandler
    public void process1(String msg) {
        System.out.println("topicReceiver1:" + msg);
    }

    @RabbitListener(queues = "topic.messages")
    @RabbitHandler
    public void process2(String msg) {
        System.out.println("topicReceiver2:" + msg);
    }
}
