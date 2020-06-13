package com.testList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Project: joycloud
 * @Package: com.testList
 * @Author: 冯前进
 * @Date: 2020-04-26 13:59
 * @Description: TODO
 **/
public class TestList {
    //list线程不安全，解决方案
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        //1、vector
        //2、 list =Collections.synchronizedList(new ArrayList<>());
        //3、new CopyOnWriteArrayList<>()
//        ConcurrentHashMap

        for(int i=0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
