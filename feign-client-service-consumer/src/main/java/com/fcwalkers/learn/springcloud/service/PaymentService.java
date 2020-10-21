package com.fcwalkers.learn.springcloud.service;

import com.fcwalkers.learn.springcloud.common.base.Result;
import com.fcwalkers.learn.springcloud.common.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("payment-service/payment")
public interface PaymentService {
    @GetMapping("getPayment/{id}")
    Result<Payment> getPayment(@PathVariable("id") Long id);
}
