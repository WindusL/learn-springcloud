package com.fcwalkers.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 在启动类上加 @EnableFeignClients 注解。Feign 接口定义跟你的启动类不在同一个包名下，
 * 还需要制定扫描的包名 @EnableFeignClients（basePackages="com.fcwalkers.learn.springcloud.client"）
 *
 * @author Windus
 * @date 2020/10/18 2:29 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.fcwalkers.learn.springcloud.service")
public class FeignClientServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientServiceConsumerApplication.class, args);
    }

}
