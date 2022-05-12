package com.bc.erp.service.impl;

import com.bc.erp.mapper.RelatedCompanyAccountMapper;
import com.bc.erp.service.RelatedCompanyAccountService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
     * 根据账户ID删除往来单位 - 账户列表
     *
     * @param accountIdList 账户ID列表
     */
    @Override
    public void deleteRcAccountList(List<String> accountIdList) {
        if (!CollectionUtils.isEmpty(accountIdList)) {
            relatedCompanyAccountMapper.deleteRcAccountList(accountIdList);
        }
    }

}