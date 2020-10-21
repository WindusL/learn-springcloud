package com.fcwalkers.learn.springcloud.paymenthystrix.service;

import org.springframework.stereotype.Component;

/**
 * 支付服务降级类
 *
 * @author Windus
 * @date 2020/10/21 11:05 下午
 */
@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public String paymentInfoOK(Long id) {
        return "PaymentServiceFallback paymentInfoOK 服务降级";
    }

    @Override
    public String paymentInfoTimeOut(Long id) {
        return "PaymentServiceFallback paymentInfoTimeOut 服务降级";
    }
}
