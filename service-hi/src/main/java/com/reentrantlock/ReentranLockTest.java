package com.reentrantlock;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project: joycloud
 * @Package: com.reentrantlock
 * @Author: 冯前进
 * @Date: 2020-01-09 16:58
 * @Description: TODO
 **/
public class ReentranLockTest implements Runnable{
    public static void main(String[] args) {
        ReentranLockTest reentranLockTest=new ReentranLockTest();
        new Thread(reentranLockTest).start();
        new Thread(reentranLockTest).start();
    }

    public void run(){
        Lock lock=new ReentrantLock();
        lock.lock();
        String threadName=Thread.currentThread().getName();
        for(int i=0;i<10;i++){
            System.out.println(threadName+"--"+i);
        }
        lock.unlock();
    }
}
