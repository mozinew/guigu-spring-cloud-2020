package com.tengol.course.sc.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 支付模块主启动类
 *
 * @author dongrui
 * @date 2021/1/16 17:31
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.tengol.course.sc.common.mapper")
public class Payment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Main.class, args);
        System.out.println("Payment8001Controller start successfully ......");
    }
}
