package com.fcwalkers.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientUserServiceApplication.class, args);
    }

}
