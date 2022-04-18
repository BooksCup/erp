package com.bc.erp.entity.ocr;

import java.util.List;

/**
 * 文字识别结果
 *
 * @author zhou
 */
public class OcrResponse {

    private String content;
    private Integer height;
    private Integer width;
    private Integer orgHeight;
    private Integer orgWidth;
    private List<PrismTablesInfo> prism_tablesInfo;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getOrgHeight() {
        return orgHeight;
    }

    public void setOrgHeight(Integer orgHeight) {
        this.orgHeight = orgHeight;
    }

    public Integer getOrgWidth() {
        return orgWidth;
    }

    public void setOrgWidth(Integer orgWidth) {
        this.orgWidth = orgWidth;
    }

    public List<PrismTablesInfo> getPrism_tablesInfo() {
        return prism_tablesInfo;
    }

    public void setPrism_tablesInfo(List<PrismTablesInfo> prism_tablesInfo) {
        this.prism_tablesInfo = prism_tablesInfo;
    }

}