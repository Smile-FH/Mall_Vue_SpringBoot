package com.fh.mall.common;

/**
 * @Description: TODO(枚举全局返回信息，目前只有SUCCESS和DB_ERROR)
 * @Author HueFu
 * @Date 2020-8-10 20:52
 */
public enum ServiceResultEnum {

    /**
     *  数据库操作失败
     */
    DB_ERROR("database error"),

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
