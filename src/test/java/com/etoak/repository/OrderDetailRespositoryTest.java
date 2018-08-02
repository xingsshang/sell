package com.etoak.repository;

import com.etoak.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRespositoryTest {
    @Autowired
    private OrderDetailRespository respository;
    @Test
    public void save(){
        OrderDetail detail = new OrderDetail();
        detail.setDetailId("1232456789");
        detail.setOrderId("12345");
        detail.setProductIcon("www.baidu.com");
        detail.setProductId("123456");
        detail.setProductName("pidanzhou");
        detail.setProductPrice(new BigDecimal(12.3));
        detail.setProductQuantity(12);
        respository.save(detail);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = respository.findByOrderId("12345");
        System.out.println("=============================="+byOrderId.size());
    }
}