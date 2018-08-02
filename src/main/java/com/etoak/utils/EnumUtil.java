package com.etoak.utils;

import com.etoak.enums.CodeEnum;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/22
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    };
}
