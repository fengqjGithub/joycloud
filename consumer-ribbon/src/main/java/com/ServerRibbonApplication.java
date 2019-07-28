package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableEurekaClient
public class ServerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    /**
     * 服务链路追踪
     *
     * 在使用 Spring Boot 2.x 版本后，官方就不推荐自行定制编译了，
     * 而是直接提供了编译好的 jar 包来给我们使用，
     * 所以在最新版本的 Spring Cloud 依赖管理里已经找不到 zipkin-server 了。
     *
     * zipkin: http://localhost:9411
     * Spring Cloud Sleuth是对Zipkin的一个封装，
     * 对于Span、Trace等信息的生成、接入HTTP Request，以及向Zipkin Server发送采集信息等全部自动完成。
     * 1、注册中心 Eureka Server（可选的，只用于服务生产者和调用者注册）
     *   2、Zipkin服务器
     *   3、服务的生产者及服务的调用者：
     *       1）服务的生产者、调用者是相对的，两者之间可以互相调用，即可以同时作为生产者和调用者，两者都是Eureka Client；
     *       2）两者都要注册到注册中心上，这样才可以相互可见，才能通过服务名来调用指定服务，才能使用Feign或RestTemplate+Ribbon来达到负载均衡
     *       3）两者都要注册到Zipkin服务器上，这样Zipkin才能追踪服务的调用链路
     */
}
