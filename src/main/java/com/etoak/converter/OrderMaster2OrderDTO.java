package com.etoak.converter;

import com.etoak.dataobject.OrderMaster;
import com.etoak.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/17
 */
public class OrderMaster2OrderDTO {
    public static OrderDTO converter(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> converter(List<OrderMaster> orderMasterList){
       return orderMasterList.stream().map(e ->converter(e)).collect(Collectors.toList());
    }
}
