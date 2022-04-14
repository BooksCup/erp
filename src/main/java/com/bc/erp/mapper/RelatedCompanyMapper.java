package com.bc.erp.mapper;

import com.bc.erp.entity.RelatedCompany;

import java.util.List;
import java.util.Map;

/**
 * 往来单位
 *
 * @author zhou
 */
public interface RelatedCompanyMapper {

    /**
     * 获取往来单位列表
     *
     * @param paramMap 参数map
     * @return 往来单位列表
     */
    List<RelatedCompany> getRelatedCompanyList(Map<String, Object> paramMap);

    /**
     * 新增往来单位
     *
     * @param relatedCompany 往来单位
     */
    void addRelatedCompany(RelatedCompany relatedCompany);

}