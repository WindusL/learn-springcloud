package com.fcwalkers.learn.springcloud.paymenthystrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfoOK(Long id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id" + id;
    }

    /**
     * 服务降级设置 @HystrixCommand命令默认级别为出错调用fallbackMethod
     * HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000") 设置超时3秒调用fallbackMethod
     *
     * @param id
     * @return
     * @date 2020/10/21 10:08 下午
     * @author Windus
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Long id) {
        int time = new Random().nextInt(5);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + ",paymentInfo_TimeOut,id" + id + "耗时：" + time + "秒";
    }

    public String paymentInfoTimeOutHandler(Long id) {

        return "线程池" + Thread.currentThread().getName() + ",paymentInfoTimeOutHandler,id" + id + "8001服务提供端异常，服务自动降级！";
    }

    // －－－－－－－－－服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            // 10秒钟内请求10次失败率达到60%开启服务熔断，使成功也不能立即恢复
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 达到失败率跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("*********id 不能为负数");
        }

        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号:" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "id 不能为负数，请稍候再试！";
    }
}
