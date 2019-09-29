package com.controller;

import com.sender.TopicSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-09-17 15:31
 * @Description: TODO
 **/
@RestController
public class TopicController {
    @Resource
    private TopicSender topicSender;

    @RequestMapping("/topicSend1")
    public String topicSend1() {
        String context = "my topic 1";
        topicSender.send(context);
        return context;
    }

    @RequestMapping("/topicSend2")
    public String topicSend2() {
        String context = "my topic 2";
        topicSender.send2(context);
        return context;
    }
}
