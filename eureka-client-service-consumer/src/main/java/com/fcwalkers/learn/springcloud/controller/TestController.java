package com.fcwalkers.learn.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getTest")
    public String getTest() {
        return restTemplate.getForObject("http://eureka-client-user-service/hello", String.class);
    }
}
