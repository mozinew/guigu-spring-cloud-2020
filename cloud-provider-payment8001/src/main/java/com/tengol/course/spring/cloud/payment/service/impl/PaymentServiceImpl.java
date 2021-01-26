package com.tengol.course.spring.cloud.payment.service.impl;

import com.tengol.course.spring.cloud.payment.entity.Payment;
import com.tengol.course.spring.cloud.payment.mapper.PaymentMapper;
import com.tengol.course.spring.cloud.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * PaymentServiceImpl
 *
 * @author dongrui
 * @date 2021/1/26 19:41
 */
@Slf4j
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
