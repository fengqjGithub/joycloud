package com.testThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: joycloud
 * @Package: com.testThread
 * @Author: 冯前进
 * @Date: 2020-07-28 17:05
 * @Description: TODO
 *
 * 两个线程打印日期
 */
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) {
        new Thread(()->{
            String date = new ThreadLocalNormalUsage00().date(10);
            System.out.println(date);
        }).start();
        new Thread(()->{
            String date = new ThreadLocalNormalUsage00().date(10000);
            System.out.println(date);
        }).start();
    }
    public String date(int seconds) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
