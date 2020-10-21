package com.fcwalkers.learn.springcloud.order.controller;

import com.fcwalkers.learn.springcloud.common.base.Result;
import com.fcwalkers.learn.springcloud.common.entity.Payment;
import com.fcwalkers.learn.springcloud.common.enums.SysCodeEnum;
import com.fcwalkers.learn.springcloud.order.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    private final String PAYMENT_URL = "http://payment-service/payment/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyLoadBalance myLoadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 获取payment信息
     *
     * @param id
     * @return
     * @date 2020/10/19 4:28 下午
     * @author Windus
     */
    @GetMapping("getPayment/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id) {
        log.debug("OrderController ---> getPayment 开始,请求参数 <==> [id]={}", id);
        Result<Payment> result = new Result<>();

        try {
            result = restTemplate.getForObject(PAYMENT_URL + "getPayment/" + id, Result.class);
        } catch (RestClientException e) {
            log.error("OrderController ---> getPayment 异常,请求参数 <==> [id]={}", id);
            result.setEnumCode(SysCodeEnum.FAIL);
            result.setMessage(SysCodeEnum.FAIL.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 使用自定义负载均衡方式调用
     *
     * @return
     * @date 2020/10/21 4:42 下午
     * @author Windus
     */
    @GetMapping("getPaymentByMyLoadBalance")
    public String getPaymentByMyLoadBalance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("payment-service");

        if (instances == null || instances.size() < 0) {
            return null;
        }

        ServiceInstance instance = myLoadBalance.instance(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri + "/payment/getPayment/1", String.class);
    }
}
