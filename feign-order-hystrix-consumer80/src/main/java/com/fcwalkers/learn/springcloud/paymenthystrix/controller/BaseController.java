package com.fcwalkers.learn.springcloud.paymenthystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller父类
 *
 * @author Windus
 * @DefaultProperties 配置全局服务降级操作，如果子类方法指定@HystrixCommand注解并且没有设置fallbackMethod 则调用全局fallbackMethod。
 * @date 2020/10/21 10:48 下午
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallbackHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
})
public class BaseController {

    /**
     * 全局服务降级函数
     * 常见的服务降级情况：1、运行时异常2、超时3、宕机
     *
     * @return
     * @date 2020/10/21 10:56 下午
     * @author Windus
     */
    public String paymentGlobalFallbackHandler() {
        return "线程池：" + Thread.currentThread().getName() + "，80消费端服务异常，全局自动降级！";
    }
}
