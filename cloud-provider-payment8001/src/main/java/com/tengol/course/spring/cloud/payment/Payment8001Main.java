package com.tengol.course.spring.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 支付模块控制器
 *
 * @author dongrui
 * @date 2021/1/16 17:31
 */
@SpringBootApplication
public class Payment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Main.class, args);
        System.out.println("Payment8001Controller start successfully ......");
    }
}
