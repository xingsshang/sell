package com.etoak.service;

import com.etoak.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author 邢尚尚
 * @Date 2018/5/13
 */
public interface CategoryService{

    /**    
      *   
      * @author xingsshang  
      * @date 2018/5/13 15:36
      * @param  * @param null  
      * @return   
      */   
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();
    // 有些方法名是固定的格式来写的 就像下边这个方法一样
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
