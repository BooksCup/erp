package com.bc.erp.enums;

/**
 * "是" "否"标记
 *
 * @author zhou
 */
public enum FlagEnum {

    /**
     * 接口返回信息
     */
    FALSE("0", "否"),
    TRUE("1", "是"),
    ;

    FlagEnum(String code, String message) {
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
