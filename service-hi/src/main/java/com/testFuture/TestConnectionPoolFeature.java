package com.testFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Project: joycloud
 * @Package: com.testFuture
 * @Author: 冯前进
 * @Date: 2020-07-30 15:14
 * @Description: TODO
 * <p>
 * 推演一遍：当3个线程同时进入else语句块时，各自都创建了一个FutureTask，但是ConcurrentHashMap只会加入其中一个。
 * 第一个线程执行pool.putIfAbsent方法后返回null，然后connectionTask被赋值，接着就执行run方法去创建连接，最后get。
 * 后面的线程执行pool.putIfAbsent方法不会返回null，就只会执行get方法。
 * <p>
 * 在并发的环境下，通过FutureTask作为中间转换，成功实现了让某个方法只被一个线程执行。
 **/
public class TestConnectionPoolFeature {

    private ConcurrentHashMap<String, FutureTask<Connection>> pool = new ConcurrentHashMap<>();

    public Connection getConnection(String key) throws ExecutionException, InterruptedException {
        FutureTask<Connection> connectionFutureTask = pool.get(key);
        if (connectionFutureTask != null) {
            return connectionFutureTask.get();
        } else {
            Callable<Connection> callable = new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    return createCollencion();
                }
            };
            FutureTask<Connection> newTask = new FutureTask<>(callable);
            connectionFutureTask = pool.put(key, newTask);
            if (connectionFutureTask == null) {
                connectionFutureTask = newTask;
                connectionFutureTask.run();
            }
            return connectionFutureTask.get();
        }
    }

    Connection createCollencion() {
        return new Connection();
    }

    class Connection {

    }
}



