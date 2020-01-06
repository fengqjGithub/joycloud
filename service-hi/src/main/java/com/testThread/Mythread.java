package com.testThread;

/**
 * @Project: joycloud
 * @Package: com.testThread
 * @Author: 冯前进
 * @Date: 2020-01-06 21:07
 * @Description: TODO
 **/
public class Mythread extends Thread{
    private int num;
    public Mythread(int num){
        this.num=num;
    }

    @Override
    public void run() {
        while ((num--)>0){
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        int num =10;
        for(int i=0;i<2;i++){
            Mythread mythread=new Mythread(num);
            mythread.start();
        }
    }
}
