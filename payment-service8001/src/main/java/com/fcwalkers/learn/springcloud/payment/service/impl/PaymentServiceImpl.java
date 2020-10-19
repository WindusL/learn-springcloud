package com.fcwalkers.learn.springcloud.payment.service.impl;

import com.fcwalkers.learn.springcloud.common.entity.Payment;
import com.fcwalkers.learn.springcloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * 支付服务类
 *
 * @author Windus
 * @date 2020/10/19 2:49 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public int save(Payment payment) {
        return 1;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return new Payment(1, "充值");
    }
}
