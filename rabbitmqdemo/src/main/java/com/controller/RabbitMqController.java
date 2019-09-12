package com.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-09-12 17:21
 * @Description: TODO
 **/
@RestController
public class RabbitMqController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/send.do")
    public String send(String msg){
        msg+=" ---我是消息";
        amqpTemplate.convertAndSend("testQueue",msg);

        amqpTemplate.convertAndSend("testQueue2",msg+"---2222");

        return msg;
    }
}
