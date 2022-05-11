package com.bc.erp.service;

/**
 * 物品属性
 *
 * @author zhou
 */
public interface GoodsAttrService {

    /**
     * 根据属性ID删除属性
     *
     * @param attrId 属性ID
     */
    void deleteGoodsAttrById(String attrId);

}