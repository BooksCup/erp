package com.bc.erp.enums;

/**
 * 物品类型
 *
 * @author zhou
 */
public enum GoodsTypeEnum {

    /**
     * 物品类型
     */
    GARMENT("1", "服装", "ZGG"),
    FABRIC("2", "面料", "ZGF"),
    /**
     * UnDefined
     */
    UD("99", "未定义", "UD"),
    ;

    GoodsTypeEnum(String code, String name, String orderSymbol) {
        this.code = code;
        this.name = name;
        this.orderSymbol = orderSymbol;
    }

    private String code;
    private String name;
    private String orderSymbol;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderSymbol() {
        return orderSymbol;
    }

    public void setOrderSymbol(String orderSymbol) {
        this.orderSymbol = orderSymbol;
    }

    public static String getOrderSymbolByName(String name) {
        GoodsTypeEnum[] goodsTypeEnums = values();
        for (GoodsTypeEnum goodsTypeEnum : goodsTypeEnums) {
            if (goodsTypeEnum.getName().equals(name)) {
                return goodsTypeEnum.getOrderSymbol();
            }
        }
        return UD.getOrderSymbol();
    }

}