package com.etoak.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.swing.text.MaskFormatter;


/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/17
 */
@Data
public class OrderForm {
    /*买家名称*/
    @NotEmpty(message = "姓名必填")
    private String name;
    /*买家电话*/
    @NotEmpty(message="手机号必填")
    private String phone;
    /*买家地址*/
    @NotEmpty(message="地址必填")
    private  String address;
    /*买家openid*/
    @NotEmpty(message = "买家openid必填")
    private  String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
