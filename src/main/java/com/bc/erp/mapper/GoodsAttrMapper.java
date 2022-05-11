package com.bc.erp.mapper;

import com.bc.erp.entity.GoodsAttr;

import java.util.List;

/**
 * 物品属性
 *
 * @author zhou
 */
public interface GoodsAttrMapper {

    /**
     * 新增物品属性列表
     *
     * @param goodsAttrList 物品属性列表
     */
    void addGoodsAttrList(List<GoodsAttr> goodsAttrList);

    /**
     * 修改物品属性列表
     *
     * @param goodsAttrList 物品属性列表
     */
    void updateGoodsAttrList(List<GoodsAttr> goodsAttrList);

    /**
     * 根据物品主键获取物品属性列表
     *
     * @param goodsId 物品主键
     * @return 物品属性列表
     */
    List<GoodsAttr> getGoodsAttrListByGoodsId(String goodsId);

    /**
     * 根据物品主键删除物品属性
     *
     * @param goodsId 物品主键
     */
    void deleteGoodsAttrByGoodsId(String goodsId);

    /**
     * 根据属性ID删除属性
     *
     * @param attrId 属性ID
     */
    void deleteGoodsAttrById(String attrId);

}