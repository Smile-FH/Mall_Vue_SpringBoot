package com.fh.mall.common;

/**
 * Description: 一个公共的运行时异常类，方便异常处理
 *
 * @Author: HueFu
 * @Date: 2020-9-1 10:04
 */
public class MallException extends RuntimeException {
    public MallException() {
        super();
    }

    public MallException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     * @param message
     */
    public static void fail(String message) {
        throw new MallException(message);
    }
}
