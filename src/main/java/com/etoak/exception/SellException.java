package com.etoak.exception;

import com.etoak.enums.ResultEnum;
import lombok.Getter;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 */
/*异常是要继承运行时异常*/
@Getter
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code ,String msg) {
        super(msg);
        this.code = code;
    }
}
