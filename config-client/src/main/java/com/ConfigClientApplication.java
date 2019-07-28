package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
/**
 * 配置中心：
 * 注意：@RefreshScope 注解需要添加到读取配置的类上
 *
 * 1：客户端的spring.application.name配置config-clent是和Git服务器上面的文件名相对应的，
 * 如果你的客户端是其他名字就报错找不到参数。
 * Git上面是有这个config-client-dev的配置文件的所以是config-clent，
 * 2：客户端加载到的配置文件的配置项会覆盖本项目已有配置，比如客户端你自己配置的端口是8881，
 * 但是如果读取到config-clent-dev这个配置文件中也有配置端口为8882，
 * 那么此时客户端访问的地址应该是8882
 *
 * 消息总线：
 * http://localhost:8089/actuator/bus-refresh
 * Spring Cloud Bus 将分布式的节点用轻量的消息代理连接起来。
 * 它可以用于广播配置文件的更改或者服务之间的通讯，也可以用于监控。
 * 用Spring Cloud Bus实现通知微服务架构的配置文件的更改。
 */
}
