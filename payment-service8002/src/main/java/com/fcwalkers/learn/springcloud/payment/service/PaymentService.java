package com.fcwalkers.learn.springcloud.payment.service;

import com.fcwalkers.learn.springcloud.common.entity.Payment;

public interface PaymentService {
    /**
     * 新增支付信息
     *
     * @param
     * @return
     * @date 2020/10/19 2:53 下午
     * @author Windus
     */
    int save(Payment payment);

    /**
     * 根据主键查询支付信息
     *
     * @param id
     * @return
     * @date 2020/10/19 2:56 下午
     * @author Windus
     */
    Payment getPaymentById(Long id);
}
