package com.bc.erp.service.impl;

import com.bc.erp.mapper.RelatedCompanyContactMapper;
import com.bc.erp.service.RelatedCompanyContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 往来单位 - 联系人
 *
 * @author zhou
 */
@Service("relatedCompanyContactService")
public class RelatedCompanyContactServiceImpl implements RelatedCompanyContactService {

    @Resource
    RelatedCompanyContactMapper relatedCompanyContactMapper;

    /**
     * 根据联系人ID删除往来单位 - 联系人
     *
     * @param contactId 联系人ID
     */
    @Override
    public void deleteRcContact(String contactId){
        relatedCompanyContactMapper.deleteRcContact(contactId);
    }

}