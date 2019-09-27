package com.controller;

import com.service.DirctSendService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-09-12 17:21
 * @Description: TODO
 **/
@RestController
public class DirctController {
    //RabbitTemplate是AmqpTemplate的一个实现。
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private DirctSendService dirctSendService;

    @RequestMapping("/send.do")
    public String send(String msg){
        msg+=" ---我是消息";
        rabbitTemplate.convertAndSend("testQueue",msg);
        rabbitTemplate.convertAndSend("testQueue2",msg+"---2222");
        return msg;
    }
    @RequestMapping("/send2.do")
    public String send2(String msg){
        dirctSendService.send(msg);
        return msg;
    }
}
