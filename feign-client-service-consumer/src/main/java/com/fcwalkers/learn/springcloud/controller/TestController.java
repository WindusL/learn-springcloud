package com.fcwalkers.learn.springcloud.controller;

import com.fcwalkers.learn.springcloud.client.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestClient testClient;

    @GetMapping("/feign/getTest")
    public String getTest() {
        return "Feign " + testClient.hello();
    }
}
