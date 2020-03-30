package com.jayce.alicloud.umsserver;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableDubbo
//@DubboComponentScan(value = {"com.jayce.alicloud.umsserver"})
//@MapperScan(value = {"com.jayce.alicloud.umsserver"})
public class UmsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsServerApplication.class, args);
    }

}
