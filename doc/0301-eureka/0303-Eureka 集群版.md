# Eureka 集群版

## 为什么使用集群版
生产环境一定是使用集群版，高可用，避免单点故障。

## Eureka 原理
Eureka 包含三部分：
1. Eureka Server （单机版或集群版）： 服务注册中心
2. Service Producer ： 向注册中心注册服务信息
3. Service Consumer ： 从注册中心获取服务注册信息，然后远程调用 Service Producer

工作原理：
1. 先启动 Eureka 注册中心（单机版或集群版）
2. 启动服务提供者（比如 payment 支付服务）
3. 服务提供者启动后将自身信息注册到注册中心（以 spring.application.name 为服务别名注册到 Eureka）
4. 启动服务消费者（比如 order 订单服务），启动时也会将自身信息注册到注册中心
5. 消费者 order 服务在需要调用接口时，使用服务别名去注册中心获取实际的 RPC 远程调用地址
6. 消费者 order 服务获得到远程调用地址后，底层实际上是通过 HttpClient 技术实现远程调用的
7. 消费者 order 服务获得服务地址后会缓存到本地 JVM 内存中，默认每间隔 30s 更新一次服务调用地址

## Eureka 集群原理
多个 Eureka Server，互相注册，相互守望。

## Eureka 集群搭建
1. 创建 2 个 Eureka Server 模块
2. 

