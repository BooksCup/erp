package com.bc.erp.mapper;

import com.bc.erp.entity.RelatedCompanyAccount;

import java.util.List;

/**
 * 往来单位 - 账户
 *
 * @author zhou
 */
public interface RelatedCompanyAccountMapper {

    /**
     * 批量新增往来单位 - 账户
     *
     * @param relatedCompanyAccountList "往来单位 - 账户列表
     */
    void addRelatedCompanyAccountList(List<RelatedCompanyAccount> relatedCompanyAccountList);

    /**
     * 批量修改往来单位 - 账户
     *
     * @param relatedCompanyAccountList 往来单位 - 账户列表
     */
    void updateRelatedCompanyAccountList(List<RelatedCompanyAccount> relatedCompanyAccountList);

    /**
     * 根据账户ID删除往来单位 - 账户
     *
     * @param accountId 账户ID
     */
    void deleteRcAccount(String accountId);

}