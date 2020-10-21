package com.fcwalkers.learn.springcloud.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    /**
     * 日志级别
     * NONE：不输出日志。
     * BASIC：只输出请求方法的 URL 和响应的状态码以及接口执行的时间。
     * HEADERS：将 BASIC 信息和请求头信息输出。
     * FULL：输出完整的请求信息。
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 超时时间 (也可以通过配置文件方式配置)
     * 第一个参数是连接超时时间（ms），默认值是 10×1000；
     * 第二个参数是取超时时间（ms），默认值是 60×1000。
     *
     * @return
     * @date 2020/10/18 3:03 下午
     * @author Windus
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }
}
