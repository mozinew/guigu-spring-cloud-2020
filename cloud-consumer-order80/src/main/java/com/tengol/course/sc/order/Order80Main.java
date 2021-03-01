package com.tengol.course.sc.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Order80Main
 *
 * @author dongrui
 * @date 2021/02/16
 */
@Slf4j
@SpringBootApplication
public class Order80Main {
    public static void main(String[] args) {
        SpringApplication.run(Order80Main.class, args);
        log.info("Order80Main start successfully ...");
    }
}
