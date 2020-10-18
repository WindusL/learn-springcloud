package com.fcwalkers.learn.springcloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client-user-service")
public interface TestClient {
    @GetMapping("/hello")
    String hello();
}
