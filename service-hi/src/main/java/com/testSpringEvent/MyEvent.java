package com.testSpringEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @Project: sfrz
 * @Package: com.zr.testSpringEvent
 * @Author: 冯前进
 * @Date: 2019-07-31 17:16
 * @Description: TODO
 **/
public class MyEvent extends ApplicationEvent {
    private String a;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source, String a) {
        super(source);
        this.a=a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
