package com.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-09-17 15:31
 * @Description: TODO
 **/
@RestController
public class TopicController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/topicSend1")
    public String topicSend1() {
        String context = "my topic 1";
        System.out.println("发送者说 : " + context);
        /**
         * 第一个参数是交换机名称,第二个参数是发送的key,第三个参数是内容,
         * RabbitMQ将会根据第二个参数去寻找有没有匹配此规则的队列,
         * 如果有,则把消息给它,如果有不止一个,则把消息分发给匹配的队列
         */
        this.amqpTemplate.convertAndSend("exchange", "topic.message", context);
        return context;
    }

    @RequestMapping("/topicSend2")
    public String topicSend2() {
        String context = "my topic 2";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
        return context;
    }
}
