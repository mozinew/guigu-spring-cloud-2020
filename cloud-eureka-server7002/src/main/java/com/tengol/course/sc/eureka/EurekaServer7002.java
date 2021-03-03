package com.tengol.course.sc.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer7002
 *
 * @author dongrui
 * @date 2021/03/01
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002.class, args);
        log.info("Eureka server start successfully ...");
    }
}
