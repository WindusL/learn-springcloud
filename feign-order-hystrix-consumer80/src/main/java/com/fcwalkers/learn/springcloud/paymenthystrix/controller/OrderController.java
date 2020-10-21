package com.fcwalkers.learn.springcloud.paymenthystrix.controller;

import com.fcwalkers.learn.springcloud.paymenthystrix.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController extends BaseController{
    @Resource
    private PaymentService paymentService;

    @GetMapping("paymentInfoOK/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id) {
        return paymentService.paymentInfoOK(id);
    }

    /**
     * 服务降级设置 @HystrixCommand命令默认级别为出错调用fallbackMethod
     * HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000") 设置超时3秒调用fallbackMethod
     * hystrix 服务降级可以配置在服务提供端，也可配置在服务消费端，一般建议配置在消费端
     *
     * @param id
     * @return
     * @date 2020/10/21 10:08 下午
     * @author Windus
     */
    @GetMapping(value = "paymentInfoTimeOut/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(@PathVariable("id") Long id) {
        return paymentService.paymentInfoTimeOut(id);
    }

    public String paymentInfoTimeOutHandler(Long id) {
        return "线程池：" + Thread.currentThread().getName() + "，80消费端服务异常，服务自动降级！";
    }
}
