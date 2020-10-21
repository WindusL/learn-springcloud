package com.fcwalkers.learn.springcloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalance {

    /**
     * 获取服务实例
     *
     * @param instances 服务实例列表
     * @return
     * @date 2020/10/21 3:39 下午
     * @author Windus
     */
    ServiceInstance instance(List<ServiceInstance> instances);
}
