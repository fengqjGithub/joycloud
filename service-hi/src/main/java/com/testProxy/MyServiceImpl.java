package com.testProxy;

/**
 * @Project: joycloud
 * @Package: com.testProxy
 * @Author: 冯前进
 * @Date: 2019-09-12 11:46
 * @Description: TODO
 **/
public class MyServiceImpl implements MyService {

    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void del() {
        System.out.println("del");
    }
}
