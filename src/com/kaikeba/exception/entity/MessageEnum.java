package com.kaikeba.exception.entity;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/22 20:58
 */
public enum MessageEnum {
    CODE_110("110","警告"),
    CODE_120("120","紧急");
    private String code;
    private String message;

    MessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
