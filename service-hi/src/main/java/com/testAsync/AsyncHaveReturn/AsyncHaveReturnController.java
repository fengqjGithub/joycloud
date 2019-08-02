package com.testAsync.AsyncHaveReturn;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Project: joycloud
 * @Package: com.testAsync.AsyncHaveReturn
 * @Author: 冯前进
 * @Date: 2019-08-02 21:45
 * @Description: TODO
 **/
@RestController
public class AsyncHaveReturnController {
    @Autowired
    AsyncHaveReturnService asyncHaveReturnService;

    @RequestMapping("/getAsyncReturn")
    public String getAsyncReturn(int k) {
        long start = System.currentTimeMillis();
        List<Future<String>> futures=new ArrayList<>();
        List<String> res=new ArrayList<>();
        Map returnMap=new HashMap();
        System.out.println(Thread.currentThread().getName()+"--主线程名字");
        try {
            for(int i=0;i<=k;i++){
                Future<String> feature = asyncHaveReturnService.doNoReturn(i);
                futures.add(feature);
            }
            for(Future<String> myFuture:futures){
                res.add(myFuture.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        returnMap.put("useTime",System.currentTimeMillis()-start);
        returnMap.put("res",res);
        return JSON.toJSONString(returnMap);
    }
}
