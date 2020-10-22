package com.fcwalkers.learn.springcloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * GateWay 全局自定义过滤器
 *
 * @author Windus
 * @date 2020/10/22 11:39 下午
 */
@Slf4j
@Component
public class GateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***************前置过滤器实现，进入GateWayFilter，{}", new Date());

        // 获取请求参数 userName
        String userName = exchange.getRequest().getQueryParams().getFirst("userName");
        if (userName == null) {
            log.info("************用户名为空，非法用户！！！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("**************后置过滤器实现，过滤器完过滤完成");
        }));
    }

    /**
     * 过滤器优先级，数值越大优先级越低
     *
     * @return
     * @date 2020/10/22 11:53 下午
     * @author Windus
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
