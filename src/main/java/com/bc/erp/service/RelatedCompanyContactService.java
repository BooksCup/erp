package com.bc.erp.service;

import java.util.List;

/**
 * 往来单位 - 联系人
 *
 * @author zhou
 */
public interface RelatedCompanyContactService {

    /**
     * 根据联系人ID删除往来单位 - 联系人列表
     *
     * @param contactList 联系人ID列表
     */
    void deleteRcContactList(List<String> contactList);

}