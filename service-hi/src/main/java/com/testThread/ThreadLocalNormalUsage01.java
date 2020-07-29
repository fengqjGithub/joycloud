package com.testThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: joycloud
 * @Package: com.testThread
 * @Author: 冯前进
 * @Date: 2020-07-28 17:09
 * @Description: TODO
 * 三十个线程打印日期
 */
public class ThreadLocalNormalUsage01 {

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<30;i++){
            int a=i;
            new Thread(()->{
                String date = new ThreadLocalNormalUsage00().date(a);
                System.out.println(date);
            }).start();
            //线程启动后，休眠100ms
            Thread.sleep(100);
        }
    }

    public String date(int seconds) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
