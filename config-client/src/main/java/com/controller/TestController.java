package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: joycloud
 * @Package: com.controller
 * @Author: 冯前进
 * @Date: 2019-07-26 23:07
 * @Description: TODO
 **/
@RestController
@RefreshScope//配置消息总线实时刷新配置文件
public class TestController {
    @Value("${foo}")
    private String foo;

    @RequestMapping("/getfoo")
    public String getConfigFoo(){
        return foo;
    }
}
