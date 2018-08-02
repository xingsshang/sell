package com.etoak.repository;


import com.etoak.dataobject.ProductCategory;
import com.etoak.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOne(){
        ProductCategory one = productCategoryRepository.findOne(1);
        System.out.println(one);
    }
    @Test
    @Transactional/*transactional注解是 避免在数据库存在脏数据*/
    public void saveTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(10);
        ProductCategory productCategory1 = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(productCategory1);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> a = Arrays.asList(2,3);
        List<ProductCategory> byCategoryTypeIn = productCategoryRepository.findByCategoryTypeIn(a);
        Assert.assertNotEquals(0,byCategoryTypeIn.size());
    }
}