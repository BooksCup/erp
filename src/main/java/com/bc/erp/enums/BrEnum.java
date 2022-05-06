package com.bc.erp.enums;

/**
 * 物料号规则
 *
 * @author zhou
 */
public enum BrEnum {

    // 物料号规则
    /**
     * eg:2205F001
     */
    GOODS_NO_RULE0001("GOODS_NO_RULE0001", "年(yy) + 月(MM) + symbol + 序列号(补齐三位数)"),

    // 订单号规则
    // 销售订单
    /**
     * eg:22ZGG0301
     */
    SALES_ORDER_NO_RULE0001("SALES_ORDER_NO_RULE0001", "年(yy) + ZGG + 月(MM) + 序列号(补齐两位数)"),

    // 采购订单
    /**
     * eg:22ZGG0301-J
     */
    PURCHASE_ORDER_NO_RULE0001("PURCHASE_ORDER_NO_RULE0001" , "销售父订单单号 + '-' + symbol"),
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