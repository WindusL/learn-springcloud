package com.fcwalkers.learn.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 当使用eureka注册中心时使用@EnableEurekaClient，其他注册中心如Nacos则使用@EnableDiscoveryClient注解
 *
 * @author Windus
 * @date 2020/10/19 4:16 下午
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderConsumerApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerApplication80.class, args);
    }
}
