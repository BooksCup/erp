package com.bc.erp.mapper;

import com.bc.erp.entity.EnterpriseBr;

/**
 * 企业业务规则
 *
 * @author zhou
 */
public interface EnterpriseBrMapper {

    /**
     * 获取企业业务规则
     *
     * @param enterpriseId 企业ID
     * @return 企业业务规则
     */
    EnterpriseBr getEnterpriseBr(String enterpriseId);

}