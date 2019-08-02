package com.testAsync.AsyncNoReturn;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Project: joycloud
 * @Package: com.testAsync.AsyncNoReturn
 * @Author: 冯前进
 * @Date: 2019-08-02 11:07
 * @Description: TODO
 **/
@Service
public class TestServiceNo {
    @Async
    public void doNoReturn(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
