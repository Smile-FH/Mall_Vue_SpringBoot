package com.fh.mall.common;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-10 20:52
 */
public enum ServiceResultEnum {

    /**
     *  Service运行且返回成功
     */
    SUCCESS("success");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }


}
