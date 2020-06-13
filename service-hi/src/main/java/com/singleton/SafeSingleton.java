package com.singleton;

/**
 * @Project: joycloud
 * @Package: com.singleton
 * @Author: 冯前进
 * @Date: 2020-04-26 9:41
 * @Description: TODO
 **/
public class SafeSingleton {
    private SafeSingleton() {
        System.out.println("--初始化---");
    }
    private volatile SafeSingleton instance=null;

    SafeSingleton getInstance(){
        if(instance==null){
            synchronized (SafeSingleton.class){
                if(instance==null) {
                    instance = new SafeSingleton();
                }
            }
        }
        return instance;
    }
}
