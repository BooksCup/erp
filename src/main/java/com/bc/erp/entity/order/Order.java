package com.bc.erp.entity.order;

import com.bc.erp.entity.GoodsSpec;
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
    private String parentId;
    private String type;
    private String no;

    private String rcId;
    private String rcName;

    private String rcContactId;
    private String rcContactName;

    private String projectId;
    private String projectName;

    private String goodsId;
    private String goodsName;
    private String goodsNo;
    private String goodsSpecX;
    private String goodsSpecY;
    private String goodsPhotos;
    private String goodsUnit;
    private String typeName;
    private List<GoodsSpec> goodsSpecList;

    private String currency;
    private String createId;
    private String createName;
    private String createTime;

    private String priceMethod;
    private String priceData;

    private List<OrderMaterial> orderMaterialList;
    private List<OrderDelivery> orderDeliveryList;

    public Order() {

    }

    public Order(String enterpriseId, String type, String rcId, String rcContactId,
                 String goodsId, String projectId, String createId, String priceMethod, String priceData, String currency,
                 List<OrderMaterial> orderMaterialList, List<OrderDelivery> orderDeliveryList) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.type = type;
        this.rcId = rcId;
        this.rcContactId = rcContactId;
        this.goodsId = goodsId;
        this.projectId = projectId;
        this.createId = createId;
        this.priceMethod = priceMethod;
        this.priceData = priceData;
        this.currency = currency;
        this.orderMaterialList = orderMaterialList;
        this.orderDeliveryList = orderDeliveryList;
    }

    public Order(String enterpriseId, String rcId, String rcContactId, String projectId, String createId,
                 String priceMethod, String priceData, String currency,
                 List<OrderMaterial> orderMaterialList, List<OrderDelivery> orderDeliveryList) {
        this.enterpriseId = enterpriseId;
        this.rcId = rcId;
        this.rcContactId = rcContactId;
        this.projectId = projectId;
        this.createId = createId;
        this.priceMethod = priceMethod;
        this.priceData = priceData;
        this.currency = currency;
        this.orderMaterialList = orderMaterialList;
        this.orderDeliveryList = orderDeliveryList;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRcId() {
        return rcId;
    }

    public void setRcId(String rcId) {
        this.rcId = rcId;
    }

    public String getRcName() {
        return rcName;
    }

    public void setRcName(String rcName) {
        this.rcName = rcName;
    }

    public String getRcContactId() {
        return rcContactId;
    }

    public void setRcContactId(String rcContactId) {
        this.rcContactId = rcContactId;
    }

    public String getRcContactName() {
        return rcContactName;
    }

    public void setRcContactName(String rcContactName) {
        this.rcContactName = rcContactName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsSpecX() {
        return goodsSpecX;
    }

    public void setGoodsSpecX(String goodsSpecX) {
        this.goodsSpecX = goodsSpecX;
    }

    public String getGoodsSpecY() {
        return goodsSpecY;
    }

    public void setGoodsSpecY(String goodsSpecY) {
        this.goodsSpecY = goodsSpecY;
    }

    public String getGoodsPhotos() {
        return goodsPhotos;
    }

    public void setGoodsPhotos(String goodsPhotos) {
        this.goodsPhotos = goodsPhotos;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<GoodsSpec> getGoodsSpecList() {
        return goodsSpecList;
    }

    public void setGoodsSpecList(List<GoodsSpec> goodsSpecList) {
        this.goodsSpecList = goodsSpecList;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPriceMethod() {
        return priceMethod;
    }

    public void setPriceMethod(String priceMethod) {
        this.priceMethod = priceMethod;
    }

    public String getPriceData() {
        return priceData;
    }

    public void setPriceData(String priceData) {
        this.priceData = priceData;
    }

    public List<OrderMaterial> getOrderMaterialList() {
        return orderMaterialList;
    }

    public void setOrderMaterialList(List<OrderMaterial> orderMaterialList) {
        this.orderMaterialList = orderMaterialList;
    }

    public List<OrderDelivery> getOrderDeliveryList() {
        return orderDeliveryList;
    }

    public void setOrderDeliveryList(List<OrderDelivery> orderDeliveryList) {
        this.orderDeliveryList = orderDeliveryList;
    }

}