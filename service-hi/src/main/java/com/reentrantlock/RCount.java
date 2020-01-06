package com.reentrantlock;


/**
 * @Project: joycloud
 * @Package: com.reentrantlock
 * @Author: 冯前进
 * @Date: 2020-01-06 21:51
 * @Description: TODO
 **/
public class RCount {
    RLock lock = new RLock();

    void get1() throws InterruptedException {
        lock.lock();
        get2();
        lock.unlock();
    }
    void get2() throws InterruptedException {
        lock.lock();
        System.out.println("nrlock--");
        lock.unlock();

    }
}
