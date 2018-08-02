package com.etoak.service.impl;

import com.etoak.dataobject.OrderDetail;
import com.etoak.dto.OrderDTO;
import com.etoak.enums.OrderStatusEnum;
import com.etoak.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl service;
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("邢尚尚");
        orderDTO.setBuyerAddress("水电费水电费是的范德萨范德萨");
        orderDTO.setBuyerOpenid("110110");
        orderDTO.setBuyerPhone("12331223123123123");
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail o1 = new  OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);
        orderDetails.add(o1);
        OrderDetail o3 = new  OrderDetail();
        OrderDetail o2  = new  OrderDetail();
        o2.setProductId("234324234");
        o2.setProductQuantity(10);
        orderDetails.add(o2);
        orderDTO.setOrderDetailList(orderDetails);
        OrderDTO dto = service.create(orderDTO);
        log.info("创建订单 result:{}",dto);
    }

    @Test
    public void findOne() {
        OrderDTO one = service.findOne("1526373365627405034");
        log.info("订单结果是restult={}",one);
        Assert.assertNotNull(one);
    }

    @Test
    public void findList() {
        PageRequest request =new PageRequest(0,2);
        Page<OrderDTO> list = service.findList("1526373365627405034", request);
        Assert.assertNotNull(list);
    }

    @Test
    public void cancel() {
        OrderDTO serviceOne = service.findOne("1526373365627405034");
        OrderDTO cancel = service.cancel(serviceOne);
        System.out.println("=================================="+cancel.getOrderStatus());
    }

    @Test
    public void finish() {

    }

    @Test
    public void paid() {
    }
    @Test
    public void findall(){
        PageRequest request =new PageRequest(0,2);
        Page<OrderDTO> list = service.findList(request);
        Assert.assertNotEquals(0,list.getTotalElements());
    }
}