# Eureka 集群版

## 为什么使用集群版
生产环境一定是使用集群版，高可用，避免单点故障。

## Eureka 原理
Eureka 包含三部分：
1. Eureka Server （单机版或集群版）： 服务注册中心
2. Service Producer ： 向注册中心注册服务信息
3. Service Consumer ： 从注册中心获取服务注册信息，然后远程调用 Service Producer
![Eureka 服务注册与发现示意图](https://si1.go2yd.com/get-image/0h3pBxsXpCK)

## Eureka 集群原理
多个 Eureka Server，搭建集群的核心点： <font color="red">互相注册，相互守望</font>。

工作原理：
1. 先启动 Eureka 注册中心（单机版或集群版）
2. 启动服务提供者（比如 payment 支付服务）
3. 服务提供者启动后将自身信息注册到注册中心（以 spring.application.name 为服务别名注册到 Eureka）
4. 启动服务消费者（比如 order 订单服务），启动时也会将自身信息注册到注册中心
5. 消费者 order 服务在需要调用接口时，使用服务别名去注册中心获取实际的 RPC 远程调用地址
6. 消费者 order 服务获得到远程调用地址后，底层实际上是通过 HttpClient 技术实现远程调用的
7. 消费者 order 服务获得服务地址后会缓存到本地 JVM 内存中，默认每间隔 30s 更新一次服务调用地址


## Eureka 集群搭建
1. 创建 2 个 Eureka Server 模块
2. 改

## 在 Eureka 集群上实现应用的高可用
在 Eureka 集群上可以实现应用的高可用，也就是多服务实例注册与发现，Consumer 调用多实例 Producer 时可以实现负载均衡。

实验步骤：
1. 参照 payment8001 再增加一个项目模块 payment 8002，修改其 pom 文件 、 yaml 文件 、 主启动类
2. 修改 pom 文件 ： 检查 jar 包
3. 修改 yaml 文件 ： 修改注册 URL 为 Eureka 集群（多个时逗号分隔）
4. 实例启动成功后，在 Eureka 管理页面查看服务实例是否注册成功
5. 修改 order80 服务，修改 config 配置文件支持负载均衡，修改 RestTemplate 调用服务的 URL 地址为 Eureka 服务名


## 错误记录

### 报错：```java.net.UnknownHostException: CLOUD-PAYMENT-SERVICE```
使用 Eureka 修改 RestTemplate 调用的 URL 后，报错 ```java.net.UnknownHostException: CLOUD-PAYMENT-SERVICE``` 。

解决方案：
需要配置负载均衡才可以使用 Eureka 的服务发现机制，因此，要给 RestTemplate 增加注解 ```@LoadBalanced``` 。
```java
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // 增加负载均衡设置
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

