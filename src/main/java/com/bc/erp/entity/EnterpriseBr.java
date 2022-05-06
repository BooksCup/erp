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
    private String salesOrderNoRule;
    private String purchaseOrderNoRule;

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

    public String getSalesOrderNoRule() {
        return salesOrderNoRule;
    }

    public void setSalesOrderNoRule(String salesOrderNoRule) {
        this.salesOrderNoRule = salesOrderNoRule;
    }

    public String getPurchaseOrderNoRule() {
        return purchaseOrderNoRule;
    }

    public void setPurchaseOrderNoRule(String purchaseOrderNoRule) {
        this.purchaseOrderNoRule = purchaseOrderNoRule;
    }

}