package com.bc.erp.service;

import com.bc.erp.entity.goods.GoodsType;

/**
 * 物品类型
 *
 * @author zhou
 */
public interface GoodsTypeService {

    /**
     * 新增物品类型
     *
     * @param goodsType 物品类型
     */
    void addGoodsType(GoodsType goodsType);

}