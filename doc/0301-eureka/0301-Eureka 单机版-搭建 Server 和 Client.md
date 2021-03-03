# 搭建单机版的 Eureka Server 和 Eureka Client

## 一、通用模式
1. 建 Module
2. 改 POM
3. 写 YAML
4. 主启动类
5. 业务方法

## 二、初始 Eureka
1. Eureka 是注册中心，分为 Server 端和 Client 端

## 三、学习 Eureka 
核心目标： 从单机到集群

### 1. 新老版本对比
```xml
<!-- 老版本 2018 -->
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>

<!-- 新版本（当前使 2020.2）-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

### 2. 搭建单机版本的 Eureka Server
（1）改 POM，引入 Eureka Server 的依赖包
    ```xml
    <!-- Eureka Server -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    ```
（2）改 YAML，增加 Eureka 配置信息，增加 `spring.application.name` 配置项
    ```yaml
    eureka:
      instance:
        hostname: localhost
      client:
        # false 表示不向注册中心注册自己
        register-with-eureka: false
        # false 表示自己端就是注册中心，不需要去检索服务
        fetch-registry: false
        service-url:
          defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
    ```
（3）编写主启动类，且增加注解 `@EnableEurekaServer`
    ```java
    package com.tengol.course.sc.eureka;
    
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
    
    /**
     * EurekaServer7001
     *
     * @author dongrui
     * @date 2021/03/01
     */
    @Slf4j
    @EnableEurekaServer
    @SpringBootApplication
    public class EurekaServer7001 {
        public static void main(String[] args) {
            SpringApplication.run(EurekaServer7001.class, args);
            log.info("Eureka server start successfully ...");
        }
    }
    ```
至此，将普通模块改造为 Eureka Client

### 3. 搭建单机版本的 Eureka Client
（1）改 POM，引入 Eureka Client 的依赖包
（2）改 YAML，增加 Eureka 配置信息，增加 `spring.application.name` 配置项
（3）主启动类增加注解 `@EnableEurekaClient`
至此，将普通模块改造为 Eureka Client

## 四、问题记录

### 1. Eureka Server 端启动后，访问管理控制台页面报错 404
检查主启动类是否包含标签 `@EnableEurekaServer` ， 该标签表示开启 Eureka 的 Server 端功能。

### 2. Client 端报错连接失败
Eureka Client 端启动时报错连接失败，配置的 `service-url` 并未生效，而是使用了默认端口 `8761` ，报错详情如下：
```java
Request execution error. endpoint=DefaultEndpoint{ serviceUrl='http://localhost:8761/eureka/}, exception=java.net.ConnectException:
```
原因： 检查配置是否正确，一定是 `defaultZone`，不能是 `default-zone`，且`defaultZone:` 之后必须得有个空格（YAML 文件语法要求）