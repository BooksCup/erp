package com.bc.erp.entity;

/**
 * 序列号
 *
 * @author zhou
 */
public class Sn {

    private String code;
    private Integer sn;
    private Integer month;
    private String modifyTime;

    public Sn() {

    }

    public Sn(String code, Integer month, Integer sn, String modifyTime) {
        this.code = code;
        this.month = month;
        this.sn = sn;
        this.modifyTime = modifyTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

}