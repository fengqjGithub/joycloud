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
public class FanoutSenfer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public Object send(Object obj) {
        rabbitTemplate.convertAndSend("fanoutExchange", "", obj);
        return obj;
    }
}
