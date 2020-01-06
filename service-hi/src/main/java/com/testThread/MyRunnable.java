package com.testThread;

/**
 * @Project: joycloud
 * @Package: com.testThread
 * @Author: 冯前进
 * @Date: 2020-01-06 21:07
 * @Description: TODO
 **/

public class MyRunnable implements Runnable {
    private int num;
    public MyRunnable(int num){
        this.num=num;
    }

    @Override
    public void run() {
        while((num--)>0){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int num =3;
        for(int i=0;i<2;i++){
            MyRunnable myRunnable=new MyRunnable(num);
            Thread thread=new Thread(myRunnable);
            thread.start();
        }
    }
}
