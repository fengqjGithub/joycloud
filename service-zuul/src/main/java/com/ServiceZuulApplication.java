package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }
/**
 * 所有从设备或网站来的请求都会经过Zuul到达后端的Netflix应用程序。作为一个边界性质的应用程序，
 * Zuul提供了动态路由、监控、弹性负载和安全功能。Zuul底层利用各种filter实现如下功能：

 1、认证和安全 识别每个需要认证的资源，拒绝不符合要求的请求。
 2、性能监测 在服务边界追踪并统计数据，提供精确的生产视图。
 3、动态路由 根据需要将请求动态路由到后端集群。
 4、压力测试 逐渐增加对集群的流量以了解其性能。
 5、负载卸载 预先为每种类型的请求分配容量，当请求超过容量时自动丢弃。
 6、静态资源处理 直接在边界返回某些响应。
 */
}
