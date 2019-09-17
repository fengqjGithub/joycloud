package com.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-09-17 16:33
 * @Description: TODO
 **/
@RestController
public class FanoutController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * Fanout Exchange形式又叫广播形式,
     * 因此我们发送到路由器的消息会使得绑定到该路由器的每一个Queue接收到消息,
     * 这个时候就算指定了Key,或者规则(即convertAndSend方法的参数2),也会被忽略
     * @return
     */
    @RequestMapping("/fanoutExchange")
    public String fanoutExchange() {
        String context = "fanoutExchange my msg ";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("fanoutExchange", "", context);
        return context;
    }
}