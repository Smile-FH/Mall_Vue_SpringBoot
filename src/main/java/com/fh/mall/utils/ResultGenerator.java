package com.fh.mall.utils;

import org.springframework.util.StringUtils;

/**
 * 封装Result类的工厂类
 * @Description:
 * @Author HueFu
 * @Date 2020-8-11 10:44
 */
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_SUCCESS_CODE = 200;
    private static final int RESULT_FAIL_CODE = 500;

    public static Result getSuccessResult(String message){
//         我可以创建一个公用的result吗
        Result result = new Result();
        result.setResultCode(RESULT_SUCCESS_CODE);
        if (StringUtils.isEmpty(message)){
            result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    public static Result getSuccessResult(Object data){
//         我可以创建一个公用的result吗
        Result result = new Result<>();
        result.setResultCode(RESULT_SUCCESS_CODE);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result getFailResult(String message){
        //         我可以创建一个公用的result吗
        Result result = new Result();
        result.setResultCode(RESULT_FAIL_CODE);
        if (StringUtils.isEmpty(message)){
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        }else {
            result.setMessage(message);
        }
        return result;
    }
    public static Result getErrorResult(int code, String message){
    //         我可以创建一个公用的result吗
            Result result = new Result();
            result.setResultCode(code);
            result.setMessage(message);
            return result;
        }
}
