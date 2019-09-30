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
 * @Date: 2019-09-12 17:25
 * @Description: TODO
 **/
@Component
public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "testQueue")
    public void receiver(String msg) {
        System.out.println("---1----testQueue get msg:" + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "testQueue2")
    public void receiver2(Channel channel, Message message) throws IOException, InterruptedException {
//        Thread.sleep(1000);
        // basicAck方法是确认消息的，它有两个参数：
        // deliveryTag（唯一标识ID）：当一个消费者向RabbitMQ注册后，会建立起一个Channel，RabbitMQ会用basic.deliver方法向消费者推送消息，
        // 这个方法携带了一个delivery tag，他代表了RabbitMQ向该Channel投递的这条消息的唯一标识ID，是一个单调递增的正整数，delivery tag的范围也仅仅局限于Channel。
        // multiple：为了减少网络流量，手动确认可以批量处理，当该参数为true时，则可以一次性确认delivery_tag小于等于传入值的所有消息。
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        System.out.println("----------c1 get msg:" + new String(message.getBody()));
    }
    @RabbitHandler
    @RabbitListener(queues = "testQueue2")
    public void receiver3(Channel channel, Message message) throws IOException, InterruptedException {
//        Thread.sleep(1000);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        System.out.println("----------c2 get msg:" + new String(message.getBody()));
    }
    @RabbitHandler
    @RabbitListener(queues = "diushiQueue")
    public void receiver4(Channel channel, Message message) throws IOException, InterruptedException {
//        Thread.sleep(1000);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        System.out.println("----------c3 get msg:" + new String(message.getBody()));
    }

}
