package com.fh.mall.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-11 10:20
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 874184924671199597L;

    private int resultCode;

    private String massage;

    private T data;
}
