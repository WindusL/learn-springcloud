package com.fcwalkers.learn.springcloud.payment.controller;

import com.fcwalkers.learn.springcloud.common.base.Result;
import com.fcwalkers.learn.springcloud.common.entity.Payment;
import com.fcwalkers.learn.springcloud.common.enums.SysCodeEnum;
import com.fcwalkers.learn.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    /**
     * 新增payment
     *
     * @param
     * @return
     * @date 2020/10/19 3:33 下午
     * @author Windus
     */
    @GetMapping("save")
    public Result<Integer> save(@RequestBody Payment payment) {
        log.debug("PaymentController ---> save 开始,请求参数 <==> [payment]={}", payment.toString());
        Result<Integer> result = new Result<>();
        try {
            int re = paymentService.save(payment);
            result.setEnumCode(SysCodeEnum.SUCCESS);
            result.setMessage(SysCodeEnum.SUCCESS.getMessage() + ",serverPort：" + serverPort);
        } catch (Exception e) {
            log.error("PaymentController ---> save 异常,请求参数 <==> [payment]={}", payment.toString());
            result.setEnumCode(SysCodeEnum.FAIL);
            result.setMessage(SysCodeEnum.FAIL.getMessage());
            e.printStackTrace();
        }

        return result;
    }


    /**
     * 获取Payment信息
     *
     * @param
     * @return
     * @date 2020/10/19 3:33 下午
     * @author Windus
     */
    @GetMapping("getPayment/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id) {
        log.debug("PaymentController ---> getPayment 开始,请求参数 <==> [id]={}", id);
        Result<Payment> result = new Result<>();

        try {
            Payment payment = paymentService.getPaymentById(id);
            result.setEnumCode(SysCodeEnum.SUCCESS);
            result.setMessage(SysCodeEnum.SUCCESS.getMessage() + ",serverPort：" + serverPort);
            result.setData(payment);
        } catch (Exception e) {
            log.error("PaymentController ---> getPayment 异常,请求参数 <==> [id]={}", id);
            result.setEnumCode(SysCodeEnum.FAIL);
            result.setMessage(SysCodeEnum.FAIL.getMessage());
            e.printStackTrace();
        }

        return result;
    }
}
