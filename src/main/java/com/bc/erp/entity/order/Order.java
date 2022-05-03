package com.bc.erp.entity.order;

import com.bc.erp.utils.CommonUtil;

import java.util.List;

/**
 * 订单
 *
 * @author zhou
 */
public class Order {

    private String id;
    private String enterpriseId;
    private String type;
    private String rcId;
    private String rcContactId;
    private String no;
    private String po;
    private String goodsId;
    private String createId;
    private String createTime;
    private List<OrderMaterial> orderMaterialList;

    public Order() {

    }

    public Order(String enterpriseId, String type, String rcId, String rcContactId,
                 String po, String goodsId, String createId, List<OrderMaterial> orderMaterialList) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.type = type;
        this.rcId = rcId;
        this.rcContactId = rcContactId;
        this.po = po;
        this.goodsId = goodsId;
        this.createId = createId;
        this.orderMaterialList = orderMaterialList;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRcId() {
        return rcId;
    }

    public void setRcId(String rcId) {
        this.rcId = rcId;
    }

    public String getRcContactId() {
        return rcContactId;
    }

    public void setRcContactId(String rcContactId) {
        this.rcContactId = rcContactId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public List<OrderMaterial> getOrderMaterialList() {
        return orderMaterialList;
    }

    public void setOrderMaterialList(List<OrderMaterial> orderMaterialList) {
        this.orderMaterialList = orderMaterialList;
    }

}