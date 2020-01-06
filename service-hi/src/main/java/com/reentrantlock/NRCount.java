package com.reentrantlock;

/**
 * @Project: joycloud
 * @Package: com.reentrantlock
 * @Author: 冯前进
 * @Date: 2020-01-06 21:51
 * @Description: TODO
 **/
public class NRCount {
    NRlock lock = new NRlock();

    void get1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        lock.lock();
        Thread c=Thread.currentThread();
        System.out.println("1");
          new Thread(() -> {
              try {
                  System.out.println(Thread.currentThread().getName());
                  System.out.println("2");
                  Thread.sleep(3000);
                  System.out.println("3");
                  c.wait(1000);
                  System.out.println("4");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }).start();
        get2();
        Thread.sleep(5000);
        lock.unlock();
    }
    void get2() throws InterruptedException {
        lock.lock();
        System.out.println("nrlock--");
        Thread.sleep(5000);
        lock.unlock();

    }
}
