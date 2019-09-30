package com.controller;

import com.sender.DirectSender;
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
    @Resource
    private DirectSender directSender;

    @RequestMapping("/send.do")
    public String send(String msg) {
        msg += " ---我是消息";
        for (int i = 0; i < 10000; i++) {
//            try {
//                Thread.sleep(10);
            directSender.send(msg + i);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        return msg;
    }

    @RequestMapping("/send2")
    public String send2(String msg) {
        msg += " ---我是测试丢失的--消息";
        for (int i = 0; i < 10000; i++) {
            directSender.send2(msg + i);
        }
        return msg;
    }
}
