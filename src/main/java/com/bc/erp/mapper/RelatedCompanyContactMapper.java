package com.bc.erp.mapper;

import com.bc.erp.entity.RelatedCompanyContact;

import java.util.List;

/**
 * 往来单位 - 联系人
 *
 * @author zhou
 */
public interface RelatedCompanyContactMapper {

    /**
     * 批量新增往来单位 - 联系人
     *
     * @param relatedCompanyContactList 往来单位 - 联系人列表
     */
    void addRelatedCompanyContactList(List<RelatedCompanyContact> relatedCompanyContactList);

    /**
     * 批量修改往来单位 - 联系人
     *
     * @param relatedCompanyContactList 往来单位 - 联系人列表
     */
    void updateRelatedCompanyContactList(List<RelatedCompanyContact> relatedCompanyContactList);

    /**
     * 根据联系人ID删除往来单位 - 联系人列表
     *
     * @param contactList 联系人ID列表
     */
    void deleteRcContactList(List<String> contactList);

}