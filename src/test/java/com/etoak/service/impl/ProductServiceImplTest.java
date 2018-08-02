package com.etoak.service.impl;

import com.etoak.dataobject.ProductInfo;
import com.etoak.repository.ProductInfoRespository;
import com.etoak.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductService service;

    @Test
    public void findOne() {
        ProductInfo info = service.findOne("123456");
        Assert.assertNotNull(info);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = service.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> all = service.findAll(pageRequest);
        System.out.println(all.getTotalElements());

    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("234324234");
        productInfo.setProductName("test2");
        productInfo.setProductDescription("这是描述");
        productInfo.setProductIcon("aaaaa");
        productInfo.setProductPrice(new BigDecimal(12));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(12);
        productInfo.setCategoryType(2);
        ProductInfo info = service.save(productInfo);
        Assert.assertNotNull(info);
    }
}