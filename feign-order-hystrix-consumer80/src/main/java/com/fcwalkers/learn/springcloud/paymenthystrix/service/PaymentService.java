package com.fcwalkers.learn.springcloud.paymenthystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 支付服务类
 * fallback 参数指定通用服务降级类
 *
 * @author Windus
 * @date 2020/10/21 11:04 下午
 */
@Component
@FeignClient(value = "payment-hystrix-service/payment", fallback = PaymentServiceFallback.class)
public interface PaymentService {
    @GetMapping("paymentInfoOK/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id);

    @GetMapping("paymentInfoTimeOut/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Long id);
}
