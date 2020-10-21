package com.fcwalkers.learn.springcloud.paymenthystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@SpringBootApplication
@EnableFeignClients(basePackages = "com.fcwalkers.learn.springcloud.paymenthystrix.service")
public class FeignOrderHystrixConsumerApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderHystrixConsumerApplication80.class, args);
    }
}
