package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Project: joycloud
 * @Package: com.service
 * @Author: 冯前进
 * @Date: 2019-07-17 19:01
 * @Description: TODO
 **/
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String consumerHello(String msg) {
        //在这里我们直接用的程序名替代了具体的url地址，
        // 在ribbon中它会根据服务名来选择具体的服务实例，
        // 根据服务实例在请求的时候会用具体的url替换掉服务名
        return restTemplate.getForObject("http://service-hi/hello?msg=" + msg, String.class);
    }
}
