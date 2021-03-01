package com.tengol.course.sc.order.web;

import com.tengol.course.sc.common.entity.CommonResult;
import com.tengol.course.sc.common.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * OrderController
 *
 * @author dongrui
 * @date 2021/02/16
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
@AllArgsConstructor
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";

    private final RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
