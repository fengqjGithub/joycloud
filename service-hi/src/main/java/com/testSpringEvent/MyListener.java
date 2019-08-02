package com.testSpringEvent;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @Project: sfrz
 * @Package: com.zr.testSpringEvent
 * @Author: 冯前进
 * @Date: 2019-07-31 17:30
 * @Description: TODO
 **/
@Component
@EnableAsync
public class MyListener {
    @EventListener
    @Async("myExecutor")
    public void addEvent(MyEvent myEvent){
        String a =myEvent.getA();
        try {
            Thread.sleep(1000*5);
            System.out.println(a+"--"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
