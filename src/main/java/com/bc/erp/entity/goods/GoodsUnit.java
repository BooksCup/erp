package com.bc.erp.entity.goods;

import com.bc.erp.utils.CommonUtil;

/**
 * 物品单位
 *
 * @author zhou
 */
public class GoodsUnit {

    private String id;
    private String enterpriseId;
    private String name;
    private String createId;
    private String createTime;

    public GoodsUnit() {

    }

    public GoodsUnit(String enterpriseId, String name, String createId) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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