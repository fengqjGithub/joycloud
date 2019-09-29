package com.rabbitmqreceiver.receivers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
    public void process1(Message message){
        System.out.println("topicReceiver1:" + message);
    }

    @RabbitListener(queues = "topic.messages")
    @RabbitHandler
    public void process2(String msg) {
        System.out.println("topicReceiver2:" + msg);
    }
}
