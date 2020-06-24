package com.zongze.common.enums;

public enum ExceptionEnum {
    SUCCESS("0", "成功"),
    TOKEN_EXPIRE("1", "登入失效,请重新登入"),
    ERR_REQ("2", "具体错误信息"),
    NEED_SMS("3", "需要短信验证"),
    SYSTEM_ERROR("500", "系统异常"),
    ;

    /**
     * 构造方法
     *
     * @param code
     * @param message
     */
    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * code
     */
    private String code;

    /**
     * 结果消息
     */
    private String message;

    /**
     * 返回 code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 返回 message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }


}
