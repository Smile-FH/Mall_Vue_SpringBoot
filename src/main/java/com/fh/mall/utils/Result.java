package com.fh.mall.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 封装@PageResult的实体类，也是返回给前端的固定数据格式
 * @Author HueFu
 * @Date 2020-8-11 10:20
 */
@Data
@NoArgsConstructor //提供一个无参构造函数
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 874184924671199597L;

    private int resultCode;

    private String message;

    private T data;
}
