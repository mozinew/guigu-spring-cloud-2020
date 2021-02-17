package com.tengol.course.spring.cloud.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CommonResult
 *
 * @author dongrui
 * @date 2021/02/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message){
        this(code, message, null);
    }
}
