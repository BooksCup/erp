package com.bc.erp.entity.stock;

import com.bc.erp.utils.CommonUtil;

/**
 * 入库单
 *
 * @author zhou
 */
public class StockIn {

    private String id;
    private String enterpriseId;
    private String wareHouseId;
    private String type;
    private String relatedCompanyId;
    private String remark;
    private String photos;
    private String entryDate;
    private String createId;
    private String createTime;

    public StockIn() {

    }

    public StockIn(String enterpriseId, String wareHouseId, String type, String relatedCompanyId,
                   String remark, String photos, String entryDate, String createId) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.wareHouseId = wareHouseId;
        this.type = type;
        this.relatedCompanyId = relatedCompanyId;
        this.remark = remark;
        this.photos = photos;
        this.entryDate = entryDate;
        this.createId = createId;
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

    public String getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(String wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelatedCompanyId() {
        return relatedCompanyId;
    }

    public void setRelatedCompanyId(String relatedCompanyId) {
        this.relatedCompanyId = relatedCompanyId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
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

}