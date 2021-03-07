package com.tengol.course.sc.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig
 *
 * @author dongrui
 * @date 2021/02/16
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // 增加负载均衡设置
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
