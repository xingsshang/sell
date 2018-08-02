package com.etoak.enums;

import lombok.Getter;

/**
 * @Description 商品状态
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"上架"),DOWN(1,"下架");

    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

    /*枚举是需要 getter方法的 */
}
