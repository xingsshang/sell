package com.etoak.handler;

import com.etoak.VO.ResultVO;
import com.etoak.config.ProjectUrlConfig;
import com.etoak.exception.ResponseBankException;
import com.etoak.exception.SellException;
import com.etoak.exception.SellerAuthorizeException;
import com.etoak.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/25
 */
/*这是处理异常的注解吗*/
@ControllerAdvice
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    // 拦截登录异常的方法
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerSellerAuthorizeException(){
        return new ModelAndView("redirect:".concat(projectUrlConfig.getSell()));
    }
    @ExceptionHandler(SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
    @ExceptionHandler(ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerBankException(){

    }
}
