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
     * 根据物品ID获取物品规格列表
     *
     * @param goodsId 物品ID
     * @return 物品规格列表
     */
    List<GoodsSpec> getGoodsSpecListByGoodsId(String goodsId);

}