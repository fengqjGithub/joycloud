package com.testAsync.AsyncNoReturn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: joycloud
 * @Package: com.testAsync.AsyncNoReturn
 * @Author: 冯前进
 * @Date: 2019-08-02 11:43
 * @Description: TODO
 **/
@RestController
public class TestControllerNo {
    @Autowired
    TestServiceNo testServiceNo;

    @RequestMapping("/testAsyncNoRetrun.do")
    public String testAsyncNoRetrun(){
        long start = System.currentTimeMillis();
        testServiceNo.doNoReturn();
        return String.format("任务执行成功,耗时{%s}", System.currentTimeMillis() - start);
    }
}
