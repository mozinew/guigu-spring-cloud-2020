package com.tengol.course.spring.cloud.payment.web;

import com.tengol.course.spring.cloud.payment.entity.CommonResult;
import com.tengol.course.spring.cloud.payment.entity.Payment;
import com.tengol.course.spring.cloud.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * PaymentController
 *
 * @author dongrui
 * @date 2021/1/26 19:42
 */
@Slf4j
@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int count = paymentService.create(payment);
        log.info("==== 插入结果：" + count);

        if(count > 0){
            return new CommonResult<>(200, "数据库插入成功");
        }else{
            return new CommonResult<>(444,"插入数据库失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(Objects.nonNull(payment)){
            return new CommonResult<>(200, "查询成功", payment);
        }else{
            return new CommonResult<>(444,"没有对应记录，查询 ID：" + id);
        }
    }
}
