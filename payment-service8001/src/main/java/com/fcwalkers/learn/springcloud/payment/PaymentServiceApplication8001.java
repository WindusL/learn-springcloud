package com.fcwalkers.learn.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务启动类
 *
 * @author Windus
 * @date 2020/10/19 12:29 上午
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentServiceApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication8001.class, args);
    }
}


