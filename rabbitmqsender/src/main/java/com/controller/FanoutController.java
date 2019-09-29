package com.controller;

import com.sender.FanoutSenfer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-09-17 16:33
 * @Description: TODO
 **/
@RestController
public class FanoutController {
    @Resource
    private FanoutSenfer fanoutSenfer;

    /**
     * Fanout Exchange形式又叫广播形式,
     * 因此我们发送到路由器的消息会使得绑定到该路由器的每一个Queue接收到消息,
     * 这个时候就算指定了Key,或者规则(即convertAndSend方法的参数2),也会被忽略
     *
     * @return
     */
    @RequestMapping("/fanoutExchange")
    public String fanoutExchange() {
        String context = "fanoutExchange my msg ";
        fanoutSenfer.send(context);
        return context;
    }
}