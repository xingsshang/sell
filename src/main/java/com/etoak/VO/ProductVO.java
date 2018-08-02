package com.etoak.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@Data
public class ProductVO {
    /*这个注解的作用是 生成json时 会把属性名修改成 对应的的属性名*/
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
