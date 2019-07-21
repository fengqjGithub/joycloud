package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Project: joycloud
 * @Package: com.service
 * @Author: 冯前进
 * @Date: 2019-07-19 19:43
 * @Description: TODO
 **/
@FeignClient(value = "service-hi",fallback = TestServiceHystrix.class)
public interface TestService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String consumerFeignSayHi(@RequestParam(value = "msg") String msg);

}
