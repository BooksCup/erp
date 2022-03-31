package com.bc.erp.entity;

import com.bc.erp.utils.CommonUtil;

/**
 * 仓库
 *
 * @author zhou
 */
public class WareHouse {

    private String id;
    private String enterpriseId;
    private String userId;
    private String parentId;
    private String name;
    private String photo;
    private String contactName;
    private String contactPhone;
    private String province;
    private String city;
    private String district;
    private String address;
    private String remark;
    private String createId;
    private String createTime;

    public WareHouse() {

    }

    public WareHouse(String enterpriseId, String userId, String parentId,
                     String name, String contactName, String contactPhone,
                     String province, String city, String address, String remark, String createId) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.userId = userId;
        this.parentId = parentId;
        this.name = name;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.province = province;
        this.city = city;
        this.address = address;
        this.remark = remark;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

}