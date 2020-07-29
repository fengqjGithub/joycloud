package com.testThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project: joycloud
 * @Package: com.testThread
 * @Author: 冯前进
 * @Date: 2020-07-28 17:26
 * @Description: TODO
 **/
public class ThreadLocalNormalUsage03 {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int a = i;
            executorService.submit(() -> {
                String date = new ThreadLocalNormalUsage00().date(a);
                System.out.println(date);
            });
        }
        executorService.shutdown();
    }

    public String date(int seconds) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
        Date date = new Date(1000 * seconds);
        return dateFormat.format(date);
    }
}
