package com.etoak.service.impl;

import com.etoak.dto.OrderDTO;
import com.etoak.enums.ResultEnum;
import com.etoak.exception.SellException;
import com.etoak.service.BuyerService;
import com.etoak.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/17
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return  checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if(orderDTO ==null){
            log.error("【取消订单】查不到此订单 orderid={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO ==null){
            return null;
        }
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(orderId)){
            log.error("【查询订单】订单的openid不一致 openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
