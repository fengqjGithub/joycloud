package com.reentrantlock;

/**
 * @Project: joycloud
 * @Package: com.reentrantlock
 * @Author: 冯前进
 * @Date: 2020-01-06 21:38
 * @Description: TODO
 **/
public class RLock {//可重入锁
    private boolean islock = false;
    private Thread lockedByThread = null;
    private int lockCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread curThread = Thread.currentThread();
        while (islock && curThread != lockedByThread) {
            wait();
        }
        lockedByThread = curThread;
        islock = true;
        lockCount++;
    }

    public synchronized void unlock() {
        lockCount--;
        if (lockCount == 0) {
            notify();
            islock = false;
        }
    }

}
