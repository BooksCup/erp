package com.bc.erp.entity.order;

import java.util.List;

/**
 * 订单交/收货期
 *
 * @author zhou
 */
public class OrderDelivery {

    private String id;
    private String enterpriseId;
    private String orderId;
    private String date;
    private String unit;
    private String remark;
    private String createId;
    private String createTime;
    private List<OrderDeliveryDetail> orderDeliveryDetailList;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<OrderDeliveryDetail> getOrderDeliveryDetailList() {
        return orderDeliveryDetailList;
    }

    public void setOrderDeliveryDetailList(List<OrderDeliveryDetail> orderDeliveryDetailList) {
        this.orderDeliveryDetailList = orderDeliveryDetailList;
    }

}