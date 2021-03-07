package com.tengol.course.sc.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PaymentDTO
 *
 * @author dongrui
 * @date 2021/3/7 13:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private String serial;
}