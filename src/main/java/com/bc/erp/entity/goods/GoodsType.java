package com.bc.erp.entity.goods;

import com.bc.erp.utils.CommonUtil;

/**
 * 物品类型
 *
 * @author zhou
 */
public class GoodsType {

    private String id;
    private String enterpriseId;
    private String name;
    private String symbol;
    private String createId;
    private String createTime;

    public GoodsType() {

    }

    public GoodsType(String enterpriseId, String name, String symbol, String createId) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.name = name;
        this.symbol = symbol;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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