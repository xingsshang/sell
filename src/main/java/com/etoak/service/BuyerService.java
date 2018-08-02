package com.etoak.service;

import com.etoak.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/17
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消一个订单
    OrderDTO cancelOrder(String openid,String orderId);

}
