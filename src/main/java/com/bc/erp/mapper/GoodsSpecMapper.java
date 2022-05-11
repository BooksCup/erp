package com.bc.erp.mapper;

import com.bc.erp.entity.GoodsSpec;

import java.util.List;

/**
 * 物品规格
 *
 * @author zhou
 */
public interface GoodsSpecMapper {

    /**
     * 新增物品规格列表
     *
     * @param goodsSpecList 物品规格列表
     */
    void addGoodsSpecList(List<GoodsSpec> goodsSpecList);

    /**
     * 修改物品规格列表
     *
     * @param goodsSpecList 物品规格列表
     */
    void updateGoodsSpecList(List<GoodsSpec> goodsSpecList);

    /**
     * 根据物品ID获取物品规格列表
     *
     * @param goodsId 物品ID
     * @return 物品规格列表
     */
    List<GoodsSpec> getGoodsSpecListByGoodsId(String goodsId);

}