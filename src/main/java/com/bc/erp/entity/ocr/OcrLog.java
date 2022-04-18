package com.bc.erp.entity.ocr;

import com.bc.erp.utils.CommonUtil;

/**
 * 文字识别日志
 *
 * @author zhou
 */
public class OcrLog {

    private String id;
    private String moduleType;
    private String paramUrl;
    private String status;
    private Long cost;
    private String resultUrl;
    private String createTime;

    public OcrLog() {

    }

    public OcrLog(String moduleType, String paramUrl) {
        this.id = CommonUtil.generateId();
        this.moduleType = moduleType;
        this.paramUrl = paramUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getParamUrl() {
        return paramUrl;
    }

    public void setParamUrl(String paramUrl) {
        this.paramUrl = paramUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}