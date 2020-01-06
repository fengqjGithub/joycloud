package com.testHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: joycloud
 * @Package: com.testHashMap
 * @Author: 冯前进
 * @Date: 2020-01-05 11:56
 * @Description: TODO
 **/
public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap =new MyHashMap();
        myHashMap.put("a","bb");
        myHashMap.put("a","aaaa");
        for(int i=0;i<10;i++){
            System.out.println(i);
            myHashMap.put("a"+i,"aaaa"+i);
        }
        System.out.println(myHashMap.get("a6"));
        System.out.println(get());
        removeHash();
    }

    public static int get(){
        int a =20;
        //10100
        //10010
        //10000
        System.out.println(++a);
        return 20 & 18;
    }

    static void removeHash(){
        Map<String,String> map=new HashMap();
        for(int i=0;i<10;i++){
            map.put("aa"+i,"bbb"+i);
        }
        map.keySet().removeIf("aa2"::equals);

    }
}
