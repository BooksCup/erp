package com.bc.erp.enums;

/**
 * 币种
 *
 * @author zhou
 */
public enum CurrencyEnum {

    /**
     * 币种
     */
    CNY("1", "¥", "人民币"),
    USD("2", "$", "美元"),
    HKD("3", "HK$", "港币"),
    ;

    CurrencyEnum(String code, String symbol, String desc) {
        this.code = code;
        this.symbol = symbol;
        this.desc = desc;
    }

    private String code;
    private String symbol;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}