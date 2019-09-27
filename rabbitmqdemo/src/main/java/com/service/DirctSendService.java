package com.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Project: joycloud
 * @Package: com.service
 * @Author: 冯前进
 * @Date: 2019-09-27 11:40
 * @Description: TODO
 **/
@Service
public class DirctSendService implements RabbitTemplate.ReturnCallback {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("回调--" + new String(message.getBody()) + i + s + s1 + s2);
    }

    public String send(String msg) {
        msg += " ---我kkk是消息";
        rabbitTemplate.setReturnCallback((message, i, s, s1, s2) -> {
            System.out.println("回调--" + new String(message.getBody()) + i + s + s1 + s2);
        });
        rabbitTemplate.convertAndSend("testQueue2", msg + "---2222");
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println("HelloSender消息发送失败" + cause + correlationData.toString());
            } else {
                System.out.println("HelloSender 消息发送成功 ");
            }
        });
        return msg;
    }

}
