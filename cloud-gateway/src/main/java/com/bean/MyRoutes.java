package com.bean;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Project: joycloud
 * @Package: com.bean
 * @Author: 冯前进
 * @Date: 2019-08-08 22:50
 * @Description: TODO
 **/
@RestController
public class MyRoutes {

    @Bean("routeLocator1")
    public RouteLocator routeLocator1(RouteLocatorBuilder builder) {
        RouteLocator routeLocator = builder.routes().route(p -> p
                .path("/get")
                .filters(f -> f.addRequestParameter("msg", "hello"))
                .uri("http://localhost:8080/testRoute")).build();
        return routeLocator;
    }

    //curl --dump-header - --header Host:www.hystrix.com http://localhost:8080/delay/3
    @Bean("routeLocator")
    public RouteLocator routeLocator2(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
