package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-08-08 23:09
 * @Description: TODO
 **/
@RestController
public class HelloController {
    @RequestMapping("/testRoute")
    public String destination(String msg){
        return msg;
    }

}
