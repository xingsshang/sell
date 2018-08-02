package com.etoak.repository;

import com.etoak.dataobject.ProductInfo;
import org.junit.Assert;
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
 * @Date 2018/5/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRespositoryTest {
    @Autowired
    private ProductInfoRespository respository;
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("Pidan");
        productInfo.setProductDescription("这是描述");
        productInfo.setProductIcon("sdsddddddfsdfds");
        productInfo.setProductPrice(new BigDecimal(12));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(12);
        productInfo.setCategoryType(2);
        ProductInfo result = respository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatus() {
        List<ProductInfo> status = respository.findByProductStatus(0);
        Assert.assertNotEquals(0,status.size());

    }
}