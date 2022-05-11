package com.bc.erp.entity;

import com.bc.erp.utils.CommonUtil;

import java.util.List;

/**
 * 往来单位
 *
 * @author zhou
 */
public class RelatedCompany {

    private String id;
    private String enterpriseId;
    private String name;
    private String alias;
    private String logo;
    private String address;
    private String email;
    private String legalPersonName;
    private String createId;
    private List<RelatedCompanyContact> relatedCompanyContactList;
    private List<RelatedCompanyAccount> relatedCompanyAccountList;

    public RelatedCompany() {

    }

    public RelatedCompany(String enterpriseId, String name, String alias, String logo,
                          String address, String legalPersonName, String createId,
                          List<RelatedCompanyContact> relatedCompanyContactList, List<RelatedCompanyAccount> relatedCompanyAccountList) {
        this.id = CommonUtil.generateId();
        this.enterpriseId = enterpriseId;
        this.name = name;
        this.alias = alias;
        this.logo = logo;
        this.address = address;
        this.legalPersonName = legalPersonName;
        this.createId = createId;
        this.relatedCompanyContactList = relatedCompanyContactList;
        this.relatedCompanyAccountList = relatedCompanyAccountList;
    }

    public RelatedCompany(String name, String alias, String address, String legalPersonName,
                          List<RelatedCompanyContact> relatedCompanyContactList, List<RelatedCompanyAccount> relatedCompanyAccountList) {
        this.name = name;
        this.alias = alias;
        this.address = address;
        this.legalPersonName = legalPersonName;
        this.relatedCompanyContactList = relatedCompanyContactList;
        this.relatedCompanyAccountList = relatedCompanyAccountList;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public List<RelatedCompanyContact> getRelatedCompanyContactList() {
        return relatedCompanyContactList;
    }

    public void setRelatedCompanyContactList(List<RelatedCompanyContact> relatedCompanyContactList) {
        this.relatedCompanyContactList = relatedCompanyContactList;
    }

    public List<RelatedCompanyAccount> getRelatedCompanyAccountList() {
        return relatedCompanyAccountList;
    }

    public void setRelatedCompanyAccountList(List<RelatedCompanyAccount> relatedCompanyAccountList) {
        this.relatedCompanyAccountList = relatedCompanyAccountList;
    }

}