package com.etoak.repository;

import com.etoak.dataobject.SellerInfo;
import com.etoak.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRespositoryTest {
    @Autowired
    private SellerInfoRespository respository;
    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = respository.findByOpenid("abc");
        System.out.println(sellerInfo);
    }
    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("abc");
        sellerInfo.setPassword("admin");
        sellerInfo.setUsername("admin");
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        respository.save(sellerInfo);
    }
}