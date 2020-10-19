package com.fcwalkers.learn.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务启动类
 *
 * @author Windus
 * @date 2020/10/19 12:29 上午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication8004.class, args);
    }
}


