package com.reentrantlock;

/**
 * @Project: joycloud
 * @Package: com.reentrantlock
 * @Author: 冯前进
 * @Date: 2020-01-06 22:41
 * @Description: TODO
 **/
public class TestWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        TestWaitNotify testWaitNotify = new TestWaitNotify();
        testWaitNotify.mywait();
    }

    synchronized void mywait() throws InterruptedException {
        System.out.println("56232323");
        new Thread(() -> {
            try {
                synchronized (this) {
                    System.out.println("888");
                    Thread.sleep(5000);
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                synchronized (this) {
                    System.out.println("---2---");
                    wait();
                    System.out.println("----3--");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        wait();
        System.out.println("11111111111111");
    }
}
