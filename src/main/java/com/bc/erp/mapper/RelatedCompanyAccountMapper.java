package com.bc.erp.mapper;

import com.bc.erp.entity.RelatedCompanyAccount;
import com.bc.erp.entity.RelatedCompanyContact;

import java.util.List;

/**
 * "往来单位" - "账户"
 *
 * @author zhou
 */
public interface RelatedCompanyAccountMapper {

    /**
     * 批量新增"往来单位" - "账户"
     *
     * @param relatedCompanyAccountList "往来单位" - "账户"列表
     */
    void addRelatedCompanyAccountList(List<RelatedCompanyAccount> relatedCompanyAccountList);

    /**
     * 批量修改"往来单位" - "账户"
     *
     * @param relatedCompanyAccountList "往来单位" - "账户"列表
     */
    void updateRelatedCompanyAccountList(List<RelatedCompanyAccount> relatedCompanyAccountList);

}