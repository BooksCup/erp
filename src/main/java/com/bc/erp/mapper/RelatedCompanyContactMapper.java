package com.bc.erp.mapper;

import com.bc.erp.entity.RelatedCompanyContact;

import java.util.List;

/**
 * "往来单位" - "联系人"
 *
 * @author zhou
 */
public interface RelatedCompanyContactMapper {

    /**
     * 批量新增"往来单位" - "联系人"
     *
     * @param relatedCompanyContactList "往来单位" - "联系人"列表
     */
    void addRelatedCompanyContactList(List<RelatedCompanyContact> relatedCompanyContactList);

    /**
     * 批量修改"往来单位" - "联系人"
     *
     * @param relatedCompanyContactList "往来单位" - "联系人"列表
     */
    void updateRelatedCompanyContactList(List<RelatedCompanyContact> relatedCompanyContactList);

}