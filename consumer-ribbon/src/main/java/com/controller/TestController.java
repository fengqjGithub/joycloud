package com.controller;

import com.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-07-17 18:57
 * @Description: TODO
 **/
@RestController
public class TestController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String consumerHello(String msg) {
        return helloService.consumerHello(msg);
    }
}
