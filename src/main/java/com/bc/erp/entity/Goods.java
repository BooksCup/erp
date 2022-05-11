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
    private String typeId;
    private String typeName;
    private String typeSymbol;
    private String specX;
    private String specY;
    private BigDecimal stockNum;
    private String unit;
    private String tags;
    private String remark;
    private String createId;
    private String createName;
    private String createTime;
    private List<GoodsAttr> goodsAttrList;
    private List<GoodsSpec> goodsSpecList;

    public Goods() {

    }

    public Goods(String enterpriseId, String name, String photos, String typeId,
                 String specX, String specY, String createId, String unit, String tags,
                 String remark,
                 List<GoodsAttr> goodsAttrList, List<GoodsSpec> goodsSpecList) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.name = name;
        this.photos = photos;
        this.typeId = typeId;
        this.specX = specX;
        this.specY = specY;
        this.createId = createId;
        this.unit = unit;
        this.tags = tags;
        this.remark = remark;
        this.goodsSpecList = goodsSpecList;
        this.goodsAttrList = goodsAttrList;
    }

    public Goods(String name, String photos, String unit, String tags, String remark,
                 List<GoodsAttr> goodsAttrList, List<GoodsSpec> goodsSpecList) {
        this.name = name;
        this.photos = photos;
        this.unit = unit;
        this.tags = tags;
        this.remark = remark;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeSymbol() {
        return typeSymbol;
    }

    public void setTypeSymbol(String typeSymbol) {
        this.typeSymbol = typeSymbol;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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