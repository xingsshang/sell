package com.etoak.enums;

import lombok.Getter;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@Getter
public enum  OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),FINISHED(1,"完结"),CANCEL(2,"取消");
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    /*枚举是需要 getter方法的 */
}
