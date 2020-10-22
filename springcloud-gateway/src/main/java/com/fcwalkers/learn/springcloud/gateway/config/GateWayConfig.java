package com.fcwalkers.learn.springcloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    /**
     * 代码方式配置路由
     * gateway 有两种方式配置路由：
     *      第一种通过配置文件配置
     *        routes:
     *         - id: payment_save # 路由ID，没有固定规则但要求唯一，建议配合服务名使用
     *           uri: http://localhost:8001 # 提供服务的路由地址
     *           predicates:
     *             - Path=/payment/save # 断言 路径相匹配的进行路由
     *      第二种配置方式就是此方法的实现方式
     *
     * @param routeLocatorBuilder
     * @return
     * @date 2020/10/22 11:11 下午
     * @author Windus
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_guonei", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route_guoji", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
