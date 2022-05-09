package com.bc.erp.entity.order;

import java.math.BigDecimal;

/**
 * 订单交/收货期明细
 *
 * @author zhou
 */
public class OrderDeliveryDetail {

    private String id;
    private String orderId;
    private String deliveryId;
    private String goodsId;
    private String specId;
    private String specX;
    private String specY;
    private BigDecimal num;
    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecX() {
        return specX;
    }

    public void setSpecX(String specX) {
        this.specX = specX;
    }

    public String getSpecY() {
        return specY;
    }

    public void setSpecY(String specY) {
        this.specY = specY;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}