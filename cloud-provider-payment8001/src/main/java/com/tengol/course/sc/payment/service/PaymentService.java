package com.tengol.course.sc.payment.service;


import com.tengol.course.sc.common.entity.Payment;

/**
 * PaymentService
 *
 * @author dongrui
 * @date 2021/1/26 19:40
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
