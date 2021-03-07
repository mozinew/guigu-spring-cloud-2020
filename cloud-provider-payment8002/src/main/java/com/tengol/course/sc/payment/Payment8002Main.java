package com.tengol.course.sc.payment;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Payment8002Main
 *
 * @author dongrui
 * @date 2021/3/7 11:30
 */
@Slf4j
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.tengol.course.sc.common.mapper")
public class Payment8002Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002Main.class, args);
        log.info("Payment 8002 start successfully ...");
    }
}
