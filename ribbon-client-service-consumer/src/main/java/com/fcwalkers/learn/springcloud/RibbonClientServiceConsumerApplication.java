package com.fcwalkers.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 当使用eureka注册中心时使用@EnableEurekaClient，其他注册中心如Nacos则使用@EnableDiscoveryClient注解
 * @date 2020/10/18 2:02 下午
 * @author Windus
 */
@EnableEurekaClient
@SpringBootApplication
public class RibbonClientServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientServiceConsumerApplication.class, args);
    }

}
