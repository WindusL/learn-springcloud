package com.fcwalkers.learn.springcloud.paymenthystrix.controller;

import com.fcwalkers.learn.springcloud.paymenthystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @GetMapping("paymentInfoOK/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id) {
        return paymentService.paymentInfoOK(id);
    }

    @GetMapping("paymentInfoTimeOut/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Long id) {
        return paymentService.paymentInfoTimeOut(id);
    }

    // －－－－－－－－－服务熔断
    @GetMapping("paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
