package com.bc.erp.enums;

/**
 * 返回消息
 *
 * @author zhou
 */
public enum ResponseMsg {

    /**
     * 接口返回信息
     */
    SUCCESS("SUCCESS", "成功"),
    ERROR("ERROR", "失败"),

    ADD_SUCCESS("ADD_SUCCESS", "新增成功"),
    ADD_ERROR("ADD_ERROR", "新增失败"),

    UPDATE_SUCCESS("UPDATE_SUCCESS", "修改成功"),
    UPDATE_ERROR("UPDATE_ERROR", "修改失败"),

    DELETE_SUCCESS("DELETE_SUCCESS", "删除成功"),
    DELETE_ERROR("DELETE_ERROR", "删除失败"),

    HANDLE_SUCCESS("HANDLE_SUCCESS", "处理成功"),
    HANDLE_ERROR("HANDLE_ERROR", "处理失败"),
    ;

    ResponseMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}