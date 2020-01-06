package com.reentrantlock;

/**
 * @Project: joycloud
 * @Package: com.reentrantlock
 * @Author: 冯前进
 * @Date: 2020-01-06 21:39
 * @Description: TODO
 **/
public class NRlock {//不可重入锁
    private boolean islock= false;
    public synchronized void lock() throws InterruptedException {
        while (islock){
            System.out.println(122);
            wait();
        }
        islock=true;
    }
    public synchronized void unlock(){
        notify();
        islock=false;
    }
}
