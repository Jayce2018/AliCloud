package com.jayce.alicloud.gatewayservey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServeyApplication.class, args);
    }

}
