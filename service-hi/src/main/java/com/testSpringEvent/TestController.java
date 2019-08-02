package com.testSpringEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Project: sfrz
 * @Package: com.zr.testSpringEvent
 * @Author: 冯前进
 * @Date: 2019-07-31 17:21
 * @Description: TODO
 **/
@RestController
public class TestController {

    @Bean("myExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("mytaskerExecutor--");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy ());
        return executor;
    }

    @Resource
    private ApplicationEventPublisher publisher;

    @GetMapping("/a")
    public String getaa(String a){
        System.out.println(a);
        publisher.publishEvent(new MyEvent(this,a));
        return a;
    }
    @GetMapping("/b")
    public String getaaaa(){
        for(int i=0;i<100;i++){
            this.getaa(i+"");
        }
        return "成功";
    }

}
