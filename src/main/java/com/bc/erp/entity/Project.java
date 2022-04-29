package com.bc.erp.entity;

import com.bc.erp.utils.CommonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 项目
 *
 * @author zhou
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {

    private String id;
    private String enterpriseId;
    private String name;
    private String createId;
    private String createTime;
    private String modifyTime;

    public Project() {

    }

    public Project(String enterpriseId, String name, String createId) {
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

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

}