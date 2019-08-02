package com.testAsync.AsyncHaveReturn;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Project: joycloud
 * @Package: com.testAsync
 * @Author: 冯前进
 * @Date: 2019-08-02 10:54
 * @Description: TODO
 **/
@Service
public class AsyncHaveReturnService {
    @Async("mytaskExecutor")
    public Future<String> doNoReturn(int i) {
        try {
            Thread.sleep(3000);
            System.out.println(i + "--------" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(String.format("参数是i=%s", i));
    }
}
