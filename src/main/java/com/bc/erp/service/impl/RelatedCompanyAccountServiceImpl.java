package com.bc.erp.service.impl;

import com.bc.erp.mapper.RelatedCompanyAccountMapper;
import com.bc.erp.service.RelatedCompanyAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 往来单位 - 账户
 *
 * @author zhou
 */
@Service("relatedCompanyAccountService")
public class RelatedCompanyAccountServiceImpl implements RelatedCompanyAccountService {

    @Resource
    RelatedCompanyAccountMapper relatedCompanyAccountMapper;

    /**
     * 根据账户ID删除往来单位 - 账户
     *
     * @param accountId 账户ID
     */
    @Override
    public void deleteRcAccount(String accountId) {
        relatedCompanyAccountMapper.deleteRcAccount(accountId);
    }

}