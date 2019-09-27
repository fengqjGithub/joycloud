package com.receicer;

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
    public void receiver2(Channel channel, Message message, String msg) throws IOException {
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("---22222----testQueue2 get msg:"+msg);
    }

}
