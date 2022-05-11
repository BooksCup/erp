package com.bc.erp.service;

import com.bc.erp.entity.RelatedCompany;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 往来单位
 *
 * @author zhou
 */
public interface RelatedCompanyService {

    /**
     * 获取往来单位列表
     *
     * @param paramMap 参数map
     * @return 往来单位列表
     */
    List<RelatedCompany> getRelatedCompanyList(Map<String, Object> paramMap);

    /**
     * 获取往来单位分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 往来单位分页信息
     */
    PageInfo<RelatedCompany> getRelatedCompanyPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);

    /**
     * 新增往来单位
     *
     * @param relatedCompany 往来单位
     */
    void addRelatedCompany(RelatedCompany relatedCompany);

    /**
     * 更新往来单位
     *
     * @param relatedCompany 往来单位
     */
    void updateRelatedCompany(RelatedCompany relatedCompany);

    /**
     * 根据主键获取往来单位
     *
     * @param id 主键
     * @return 往来单位
     */
    RelatedCompany getRelatedCompanyById(String id);

}