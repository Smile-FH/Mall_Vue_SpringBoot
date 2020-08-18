package com.fh.mall.utils;

import org.springframework.util.StringUtils;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-11 10:44
 */
public class ResultGenerator {

    /**
     * 看看后期能不能把这里的变量给删掉，在common中建立一个公共的信息包
     */
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    private static final int RESULT_SUCCESS_CODE = 200;

    private static final int RESULT_FAIL_CODE = 500;

    public static Result getSuccessResult(String message){
//         我可以创建一个公用的result吗
        Result result = new Result();
        result.setResultCode(RESULT_SUCCESS_CODE);
        result.setMassage(message);
        return result;
    }

    public static Result<Object> getSuccessResult(Object data){
//         我可以创建一个公用的result吗
        Result<Object> result = new Result<>();
        result.setResultCode(RESULT_SUCCESS_CODE);
        result.setMassage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result getFailResult(String message){
    //         我可以创建一个公用的result吗
            Result result = new Result();
            result.setResultCode(RESULT_FAIL_CODE);
            if (StringUtils.isEmpty(message)){
                result.setMassage(DEFAULT_FAIL_MESSAGE);
            }else {
                result.setMassage(message);
            }
            return result;
        }
    public static Result getErrorResult(int code, String message){
    //         我可以创建一个公用的result吗
            Result result = new Result();
            result.setResultCode(code);
            result.setMassage(message);
            return result;
        }









}
