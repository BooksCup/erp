package com.bc.erp.service;

/**
 * 往来单位 - 联系人
 *
 * @author zhou
 */
public interface RelatedCompanyContactService {

    /**
     * 根据联系人ID删除往来单位 - 联系人
     *
     * @param contactId 联系人ID
     */
    void deleteRcContact(String contactId);

}