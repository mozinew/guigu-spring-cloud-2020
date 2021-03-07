package com.tengol.course.sc.payment.web;

import com.tengol.course.sc.common.entity.CommonResult;
import com.tengol.course.sc.common.entity.Payment;
import com.tengol.course.sc.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * PaymentController
 *
 * @author dongrui
 * @date 2021/3/7 11:34
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;
    private Integer serverPort;

    public PaymentController(PaymentService paymentService, @Value("${server.port}") Integer serverPort) {
        this.paymentService = paymentService;
        this.serverPort = serverPort;
    }

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int count = paymentService.create(payment);
        log.info("==== 插入结果：" + count);

        if (count > 0) {
            return new CommonResult<>(200, "数据库插入成功，Server port : " + serverPort);
        } else {
            return new CommonResult<>(444, "插入数据库失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (Objects.nonNull(payment)) {
            return new CommonResult<>(200, "查询成功，Service port : " + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录，查询 ID：" + id);
        }
    }
}

