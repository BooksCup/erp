package com.bc.erp.service.impl;

import com.bc.erp.mapper.RelatedCompanyContactMapper;
import com.bc.erp.service.RelatedCompanyContactService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
     * 根据联系人ID删除往来单位 - 联系人列表
     *
     * @param contactList 联系人ID列表
     */
    @Override
    public void deleteRcContactList(List<String> contactList) {
        if (!CollectionUtils.isEmpty(contactList)) {
            relatedCompanyContactMapper.deleteRcContactList(contactList);
        }
    }

}