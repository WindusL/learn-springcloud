## 该项目为Feign服务提消费者
Feign 是一个声明式的 REST 客户端，它能让 REST 调用更加简单。Feign 供了 HTTP 请求的模板，通过编写简单的接口和插入注解，就可以定义好 HTTP 请求的参数、格式、地址等信息。而 Feign 则会完全代理 HTTP 请求，我们只需要像调用方法一样调用它就可以完成服务请求及相关处理。

Spring Cloud 对 Feign 进行了封装，使其支持 SpringMVC 标准注解和 HttpMessageConverters。Feign 可以与 Eureka 和 Ribbon 组合使用以支持负载均衡。