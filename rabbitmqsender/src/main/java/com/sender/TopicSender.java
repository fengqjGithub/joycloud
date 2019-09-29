package com.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Project: joycloud
 * @Package: com.sender
 * @Author: 冯前进
 * @Date: 2019-09-29 14:37
 * @Description: TODO
 **/
@Service
public class TopicSender {
    @Resource
    private RabbitTemplate rabbitTemplate;
    public Object send(Object obj) {
        String context = "my topic 88";
        /**
         * 第一个参数是交换机名称,第二个参数是发送的key,第三个参数是内容,
         * RabbitMQ将会根据第二个参数去寻找有没有匹配此规则的队列,
         * 如果有,则把消息给它,如果有不止一个,则把消息分发给匹配的队列
         */
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
        return context;
    }
    public Object send2(Object obj) {
        String context = "my topic 2";
        System.out.println("发送者说 : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
        return context;
    }
}
