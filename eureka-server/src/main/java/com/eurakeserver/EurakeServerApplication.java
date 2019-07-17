package com.eurakeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurakeServerApplication.class, args);
		System.out.println("-----server 启动成功---------");
	}

}