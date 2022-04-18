package com.bc.erp.enums;

/**
 * 文字识别模块
 *
 * @author zhou
 */
public enum OcrModuleTypeEnum {

    /**
     * 文字识别模块
     */
    DYEING_COST("DYEING_COST", "染费单"),
    ;

    OcrModuleTypeEnum(String code, String message) {
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