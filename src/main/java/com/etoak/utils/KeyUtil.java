package com.etoak.utils;

import java.util.Random;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * @author xingsshang
     * @date 2018/5/15 14:33
     * @param * @param
     * @return java.lang.String
     */
    public static synchronized String getUniqueKey(){
        Random random =new Random();
        Integer number = random.nextInt(900000) + 100000;
       return System.currentTimeMillis()+String.valueOf(number);

    };

    public static void main(String[] args) {
        Random random =new Random();
        Integer number = random.nextInt(900000) + 100000;
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()+String.valueOf(number));
    }
}
