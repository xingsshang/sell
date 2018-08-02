package com.etoak.dto;

import lombok.Data;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
