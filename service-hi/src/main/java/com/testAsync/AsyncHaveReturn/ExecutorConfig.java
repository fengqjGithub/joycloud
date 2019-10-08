package com.testAsync.AsyncHaveReturn;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Project: joycloud
 * @Package: com.testAsync.AsyncHaveReturn
 * @Author: 冯前进
 * @Date: 2019-08-02 22:57
 * @Description: TODO
 **/
@Component
public class ExecutorConfig {
    /**
     * 1、当提交一个新任务到线程池时首先线程池判断基本线程池(corePoolSize)是否已满？没满，创建一个工作线程来执行任务。满了，则进入下个流程；
     * 其次线程池判断工作队列(workQueue)是否已满？没满，则将新提交的任务存储在工作队列里。满了，则进入下个流程；
     * 最后线程池判断整个线程池(maximumPoolSize)是否已满？没满，则创建一个新的工作线程来执行任务，满了，则交给饱和策略来处理这个任务；
     * 如果线程池中的线程数量大于 corePoolSize 时，如果某线程空闲时间超过keepAliveTime，线程将被终止，
     * 直至线程池中的线程数目不大于corePoolSize；如果允许为核心池中的线程设置存活时间，那么核心池中的线程空闲时间超过 keepAliveTime，
     * 线程也会被终止。
     * 2、饱和策略：
     * Abort策略：默认策略，新任务提交时直接抛出未检查的异常RejectedExecutionException，该异常可由调用者捕获。
     * CallerRuns策略：为调节机制，既不抛弃任务也不抛出异常，而是将某些任务回退到调用者。
     * 不会在线程池的线程中执行新的任务，而是在调用exector的线程中运行新的任务。
     * -------CallerRuns策略在异步线程总数大于核心线程数+队列容量时，主线程即调用exector的线程将会执行新的任务！！！！！！！！！！！！！
     * Discard策略：新提交的任务被抛弃。
     */
    @Bean("mytaskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(2);
        // 设置队列容量
        executor.setQueueCapacity(5);
        // 设置最大线程数
        executor.setMaxPoolSize(3);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 设置默认线程名称
        executor.setThreadNamePrefix("hello-");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
