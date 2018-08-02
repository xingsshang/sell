package com.etoak.enums;

import lombok.Getter;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0,"等待支付"),SUCCESS(1,"支付成功");
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    /*枚举是需要 getter方法的 */
}
