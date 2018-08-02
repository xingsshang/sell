package com.etoak.VO;

import lombok.Data;

/**
 * @Description 返回结果的对象
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@Data
public class ResultVO<T> {
    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*具体内容*/
    private T data;
}
