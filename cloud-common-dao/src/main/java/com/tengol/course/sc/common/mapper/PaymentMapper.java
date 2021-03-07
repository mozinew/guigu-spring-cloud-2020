package com.tengol.course.sc.common.mapper;

import com.tengol.course.sc.common.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * PaymentMapper
 *
 * @author dongrui
 * @date 2021/3/7 10:50
 */
@Mapper
@Repository
public interface PaymentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Payment record);
}
