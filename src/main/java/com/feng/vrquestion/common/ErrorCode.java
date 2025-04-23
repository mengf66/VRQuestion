package com.feng.vrquestion.common;

public enum ErrorCode {
    // https://yupi.icu/

    SUCCESS(0, "ok", ""),
    PARAMS_ERROR(40000, "请求参数错误", ""),
    NULL_ERROR(40001, "请求数据为空", ""),
    ALREADY_REGISTER(40002, "用户已存在", ""),
    UNEXIST_REGISTER(40003, "用户不存在", ""),
    NOT_LOGIN(40100, "未登录", ""),
    NO_AUTH(40101, "无权限", ""),
    FORBIDDEN_ERROR(40300, "禁止访问", ""),
    FORBIDDEN(40301, "禁止操作", ""),
    NOT_FOUND_ERROR(40400, "请求数据不存在", ""),
    SYSTEM_ERROR(50000, "系统内部异常", ""),
    ADDUSER_FAIL(50001, "添加用户失败", "数据库添加失败"),
    OPERATION_ERROR(50002, "操作失败", ""),
    API_REQUEST_ERROR(50010, "接口调用失败", "");

    private final int code;

    /**
     * 状态码信息
     */
    private final String message;

    /**
     * 状态码描述（详情）
     */
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
