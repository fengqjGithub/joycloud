package com.controller;

import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-07-19 19:46
 * @Description: TODO
 **/
@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam(value = "msg") String msg) {
        return testService.consumerFeignSayHi(msg);
    }
    @GetMapping(value = "/hi2")
    public String sayHi2(@RequestParam(value = "msg") String msg) {
        return testService.consumerFeignSayHi2(msg);
    }
}
