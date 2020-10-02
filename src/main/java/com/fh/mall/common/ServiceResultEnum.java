package com.fh.mall.common;

/**
 * @Description: 枚举全局返回信息
 * @Author HueFu
 * @Date 2020-8-10 20:52
 */
public enum ServiceResultEnum {


    /**
     * 登录的用户名不是手机号
     */
    LOGIN_NAME_IS_NOT_PHONE("登录的用户名不是手机号"),

    /**
     * 用户被管理员锁定，封禁
     */
    USER_LOCKED_ERROR("当前用户已被封"),

    /**
     * 没从数据库中查到响应用户
     */
    USER_NULL_ERROR("无效用户！请重新登录！"),

    /**
     * 未登录
     */
    USER_NOT_LOGIN("您还没有登录，请先登录!"),

    /**
     * Token过期
     */
    TOKEN_EXPIRE_ERROR("无效认证，请重新登录"),

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
