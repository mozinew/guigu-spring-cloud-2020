package com.tengol.course.spring.cloud.payment.mapper;

import com.tengol.course.spring.cloud.payment.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * PaymentMapper
 *
 * @author dongrui
 * @date 2021/1/26 19:10
 */
@Mapper
@Repository
public interface PaymentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Payment record);
}
