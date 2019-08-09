package com.testLambda;

/**
 * @Project: joycloud
 * @Package: com.testLambda
 * @Author: 冯前进
 * @Date: 2019-08-09 15:44
 * @Description: TODO
 **/
public class MyLambda {
    static String getTest1() {
        String a = "hello ";
        Test1 test1 = a1 -> {
            System.out.println("------");
            return a1 + " world !";
        };
//        Test1 test1= a2 ->{
//            System.out.println("------");
//            return a2 +"word";
//        };
        test1.mytest1("aaaaaa");
        System.out.println("222");
        return a;
    }

    public static void main(String[] args) {
        getTest1();
    }

}
