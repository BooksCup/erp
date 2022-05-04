package com.bc.erp.entity;

import com.bc.erp.utils.CommonUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * 物品
 *
 * @author zhou
 */
public class Goods {

    private String id;
    private String enterpriseId;
    private String no;
    private String name;
    private String photos;
    private String type;
    private String typeName;
    private String specX;
    private String specY;
    private BigDecimal stockNum;
    private String unit;
    private String createId;
    private String createTime;
    private List<GoodsAttr> goodsAttrList;
    private List<GoodsSpec> goodsSpecList;

    public Goods() {

    }

    public Goods(String enterpriseId, String name, String photos, String type,
                 String specX, String specY, String createId, String unit,
                 List<GoodsAttr> goodsAttrList, List<GoodsSpec> goodsSpecList) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.name = name;
        this.photos = photos;
        this.type = type;
        this.specX = specX;
        this.specY = specY;
        this.createId = createId;
        this.unit = unit;
        this.goodsSpecList = goodsSpecList;
        this.goodsAttrList = goodsAttrList;
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public BigDecimal getStockNum() {
        return stockNum;
    }

    public void setStockNum(BigDecimal stockNum) {
        this.stockNum = stockNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public List<GoodsAttr> getGoodsAttrList() {
        return goodsAttrList;
    }

    public void setGoodsAttrList(List<GoodsAttr> goodsAttrList) {
        this.goodsAttrList = goodsAttrList;
    }

    public List<GoodsSpec> getGoodsSpecList() {
        return goodsSpecList;
    }

    public void setGoodsSpecList(List<GoodsSpec> goodsSpecList) {
        this.goodsSpecList = goodsSpecList;
    }

}