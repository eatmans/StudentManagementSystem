package com.eatmans.sms.domain;

/**
 * @author eatmans
 * @version 1.0
 * @date 2021/6/2
 */
public enum CodeMsg {

    /**
     * Description 响应状态码
     */
    SUCCESS(200, "请求成功"),
    FAILED(201, "请求失败"),
    REQUEST_ILLEGAL(202, "请求不合法"),
    TOKEN_EXPIRED(400, "token已过期"),
    TOKEN_ERROR(401, "token错误"),
    VISITOR_FORBIDDEN(403, "游客无权限操作"),
    LOGIN_FAILED(10002, "登陆失败"),
    BINDING_FAILED(20002, "绑定失败"),
    REPEAT_BINDING(20003, "重复绑定"),
    UNIQUE_INDEX(20004, "重复数据"),
    REPORT_FAILED(30002, "举报失败"),
    RECOMMEND_FAILED(30002, "反馈失败"),
    POST_FAILED(40002, "发送失败"),
    MISSING_PARAMETER(40003, "参数异常"),
    DATA_EXCEPTION(40003, "数据异常"),
    MISSING_RECORD(40004, "记录不存在"),
    OFF_LINE(40004, "对方不在线,已转为留言"),
    SYSTEM_ERROR(50001, "系统异常"),
    UPDATE_FAILED(60002, "更新失败"),
    REQUEST_FREQUENT(50003, "请求过于频繁"),
    DELETE_FAILED(60004, "删除失败");

    private int code;
    private String msg;
    private Integer type;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
