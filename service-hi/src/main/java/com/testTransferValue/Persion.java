package com.testTransferValue;


/**
 * @Project: joycloud
 * @Package: com.testTransferValue
 * @Author: 冯前进
 * @Date: 2020-05-09 11:17
 * @Description: TODO
 **/
public class Persion {
    private String name;
    private Integer age;

    public Persion(String name) {
        this.name = name;
    }

    public Persion() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
