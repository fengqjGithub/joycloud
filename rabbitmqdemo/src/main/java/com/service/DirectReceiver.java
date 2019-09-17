package com.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Project: joycloud
 * @Package: com.service
 * @Author: 冯前进
 * @Date: 2019-09-12 17:25
 * @Description: TODO
 **/
@Component
public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues="testQueue")
    public void receiver(String msg){
        System.out.println("---1----testQueue get msg:"+msg);
    }

    @RabbitHandler
    @RabbitListener(queues="testQueue2")
    public void receiver2(String msg){
        System.out.println("---22222----testQueue2 get msg:"+msg);
    }

}
