package com.reentrantlock;

/**
 * @Project: joycloud
 * @Package: com.reentrantlock
 * @Author: 冯前进
 * @Date: 2020-01-06 21:45
 * @Description: TODO
 **/
public class TestLock {
    public static void main(String[] args) throws InterruptedException {
//        NRCount count1=new NRCount();
//        count1.get1();
//        System.out.println("--");
        RCount count2=new RCount();
        count2.get1();
    }

}
