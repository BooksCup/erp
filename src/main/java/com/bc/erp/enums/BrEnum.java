package com.bc.erp.enums;

/**
 * 物料号规则
 *
 * @author zhou
 */
public enum BrEnum {

    /**
     * 物料号规则
     */
    /**
     * eg:2205F001
     */
    GOODS_NO_RULE0001("GOODS_NO_RULE0001", "年(yy) + 月(MM) + symbol + 序列号(补齐三位数)"),
    ;

    BrEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}