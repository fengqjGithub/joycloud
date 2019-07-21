package com.service;

import org.springframework.stereotype.Component;

/**
 * @Project: joycloud
 * @Package: com.service
 * @Author: 冯前进
 * @Date: 2019-07-21 22:12
 * @Description: TODO
 **/
@Component
public class TestServiceHystrix implements TestService{
    @Override
    public String consumerFeignSayHi(String msg) {
        return "this is error "+msg;
    }
}
