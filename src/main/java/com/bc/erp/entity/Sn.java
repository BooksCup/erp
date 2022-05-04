package com.bc.erp.entity;

/**
 * 序列号
 *
 * @author zhou
 */
public class Sn {

    private String rule;
    private String code;
    private Integer sn;
    private String modifyTime;

    public Sn() {

    }

    public Sn(String rule, String code, Integer sn, String modifyTime) {
        this.rule = rule;
        this.code = code;
        this.sn = sn;
        this.modifyTime = modifyTime;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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