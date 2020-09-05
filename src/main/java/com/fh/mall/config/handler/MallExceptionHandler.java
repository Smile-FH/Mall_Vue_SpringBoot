package com.fh.mall.config.handler;

import com.fh.mall.common.MallException;
import com.fh.mall.common.ServiceResultEnum;
import com.fh.mall.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: TODO(全局异常处理类)
 *
 * @Author: HueFu
 * @Date: 2020-9-1 10:16
 */
@RestControllerAdvice
public class MallExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e, HttpServletRequest request){
        Result result = new Result();
        result.setResultCode(500);
        if (e instanceof MallException) {
            result.setMessage(e.getMessage());
            if ( ServiceResultEnum.USER_NOT_LOGIN.getResult().equals(e.getMessage()) || ServiceResultEnum.TOKEN_EXPIRE_ERROR.getResult().equals(e.getMessage())) {
                result.setResultCode(416);
            }
        } else {
          e.printStackTrace();
          result.setMessage("未知异常，请联系管理员");
        }
        return result;
    }

}
