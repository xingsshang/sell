package com.etoak.utils;

import com.etoak.VO.ResultVO;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
public class ResultVOUtil {
    /**
     *  返回成功的方法
     * @author xingsshang
     * @date 2018/5/14 12:14
     * @param * @param object
     * @return com.etoak.VO.ResultVO
     */
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
