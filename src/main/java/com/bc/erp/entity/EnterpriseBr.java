package com.bc.erp.entity;

/**
 * 企业业务规则
 *
 * @author zhou
 */
public class EnterpriseBr {

    private String id;
    private String enterpriseId;
    private String goodsNoRule;
    private String orderNoRule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getGoodsNoRule() {
        return goodsNoRule;
    }

    public void setGoodsNoRule(String goodsNoRule) {
        this.goodsNoRule = goodsNoRule;
    }

    public String getOrderNoRule() {
        return orderNoRule;
    }

    public void setOrderNoRule(String orderNoRule) {
        this.orderNoRule = orderNoRule;
    }

}