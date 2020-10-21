package com.fcwalkers.learn.springcloud.controller;

import com.fcwalkers.learn.springcloud.common.base.Result;
import com.fcwalkers.learn.springcloud.common.entity.Payment;
import com.fcwalkers.learn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("getPayment/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }
}
