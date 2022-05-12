package com.bc.erp.enums;

/**
 * 订单计价方式
 *
 * @author zhou
 */
public enum PriceMethodEnum {

    /**
     * 订单计价方式
     */
    AVERAGE_PRICE("0", "均价"),
    ;

    PriceMethodEnum(String code, String message) {
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