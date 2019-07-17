package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: joycloud
 * @Package: controller
 * @Author: 冯前进
 * @Date: 2019-07-17 9:18
 * @Description: TODO
 **/
@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/hello")
    public String sayHello(@RequestParam(name = "msg") String msg){
        return "hello "+ msg +" I am from port:"+port;
    }
}
