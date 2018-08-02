package com.etoak.repository;

import com.etoak.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.nio.cs.ext.MS874;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void save(){
        OrderMaster master = new OrderMaster();
        master.setOrderId("123456");
        master.setBuyerName("哈哈 我是谁");
        master.setBuyerPhone("123456789");
        master.setBuyerAddress("石家庄");
        master.setBuyerOpenid("110110");
        master.setOrderAmount(new BigDecimal(2.3));
        OrderMaster save = repository.save(master);
        Assert.assertNotNull(save);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,1);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid("110110", request);
        Assert.assertNotEquals(0,byBuyerOpenid.getTotalPages());
    }
}