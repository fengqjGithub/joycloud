package com.common.entity;

import com.sun.javafx.binding.StringFormatter;

/**
 * @Project: joycloud
 * @Package: com.common.entity
 * @Author: 冯前进
 * @Date: 2020-07-06 14:29
 * @Description: TODO
 **/
public class Hello {
    private String name;

    public Hello(String name) {
        this.name = name;
    }

    public String say(String msg) {
        return StringFormatter.concat(name, ":", msg).getValue();
    }
}
