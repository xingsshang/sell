package com.etoak.service;

import com.etoak.dto.OrderDTO;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/25
 */
public interface PushMessage {
    void  orderStatus(OrderDTO orderDTO);
}
