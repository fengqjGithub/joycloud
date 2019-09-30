package com.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @Project: joycloud
 * @Package: com.sender
 * @Author: 冯前进
 * @Date: 2019-09-29 14:37
 * @Description: TODO
 **/
@Service
public class DirectSender {
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 如果消息没有到exchange,则confirm回调,ack=false
     * 如果消息到达exchange,则confirm回调,ack=true
     * exchange到queue成功,则不回调return
     * exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
     *
     * @param obj
     * @return
     */
    public Object send(Object obj) {
        rabbitTemplate.setMandatory(true);
        //启动消息失败返回，比如路由不到队列时触发回调。
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        });
        //消息发送到Broker后触发回调，确认消息是否到达Borker服务器，也就是只确认是否正确到达Exchange中。
        rabbitTemplate.setConfirmCallback((correlationData, ack, s) -> {
            System.out.println("correlationData: " + correlationData);//id + 时间戳 全局唯一
            System.out.println("ack: " + ack);
            if (!ack) {
                System.out.println("异常处理....");
            }
        });
        //id + 时间戳 全局唯一
        CorrelationData correlationData = new CorrelationData("1234567890" + new Date());
        rabbitTemplate.convertAndSend("testQueue2", obj + "---2222");
        return obj;
    }
    public Object send2(Object obj) {
        String uuid =UUID.randomUUID().toString();
        CorrelationData correlationData = new CorrelationData("123456789-"+uuid);
        rabbitTemplate.convertAndSend("one2manyExchange","diushiQueue", "发送:"+uuid,correlationData);
        return obj;
    }

}
