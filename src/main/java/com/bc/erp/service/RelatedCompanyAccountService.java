package com.bc.erp.service;

import java.util.List;

/**
 * 往来单位 - 账户
 *
 * @author zhou
 */
public interface RelatedCompanyAccountService {

    /**
     * 根据账户ID删除往来单位 - 账户列表
     *
     * @param accountIdList 账户ID列表
     */
    void deleteRcAccountList(List<String> accountIdList);

}