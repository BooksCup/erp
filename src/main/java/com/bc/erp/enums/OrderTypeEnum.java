package com.bc.erp.enums;

/**
 * 订单类型
 *
 * @author zhou
 */
public enum OrderTypeEnum {

    /**
     * 订单类型
     */
    SALES_ORDER("1", "销售订单"),
    PURCHASE_ORDER("2", "采购订单"),
    ;

    OrderTypeEnum(String code, String message) {
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