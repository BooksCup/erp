package com.bc.erp.service;

/**
 * 往来单位 - 账户
 *
 * @author zhou
 */
public interface RelatedCompanyAccountService {

    /**
     * 根据账户ID删除往来单位 - 账户
     *
     * @param accountId 账户ID
     */
    void deleteRcAccount(String accountId);

}