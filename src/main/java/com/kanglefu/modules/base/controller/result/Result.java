package com.kanglefu.modules.base.controller.result;

import java.io.Serializable;

/**
 * Controller 返回结果封装
 * Created by Michael on 2017/7/15.
 */
public class Result implements Serializable {

    private static final long serialVersionUID = -4774033891136934323L;

    private static final Result LOGIN_REQUIRED = new Result(Type.LOGIN_REQUIRED);
    private static final Result ERROR = new Result(Type.ERROR);
    private static final Result SUCCESS = new Result(Type.SUCCESS);
    private static final Result PERMISSION_DENIED = new Result(Type.PERMISSION_DENIED);

    /**
     *  结果码
     */
    private int code;

    /**
     *  提示信息
     */
    private String msg;

    /**
     *  相关数据
     */
    private Object data;

    /**
     *  时间戳
     */
    private long time;

    private Result() {
    }

    private Result(Type type) {
        this.code = type.code;
        this.msg = type.defaultMsg;
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Result setTime(long time) {
        this.time = time;
        return this;
    }

    public static Result loginRequired(){
        return LOGIN_REQUIRED.setTime(System.currentTimeMillis());
    }

    public static Result error() {
        return ERROR.setTime(System.currentTimeMillis());
    }

    public static Result success(){
        return SUCCESS.setTime(System.currentTimeMillis());
    }

    public static Result permissionDenied() {
        return PERMISSION_DENIED.setTime(System.currentTimeMillis());
    }

    private enum Type {
        LOGIN_REQUIRED(-1, "请先登录"),
        ERROR(0, "系统异常"),
        SUCCESS(1, "操作成功!"),
        PERMISSION_DENIED(2, "没有这个权限");
        private int code; // 访问结果类型编码
        private String defaultMsg; // 默认提示信息

        Type(int code, String defaultMsg) {
            this.code = code;
            this.defaultMsg = defaultMsg;
        }
    }
}
