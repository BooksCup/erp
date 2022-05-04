package com.bc.erp.service;

import com.bc.erp.entity.goods.GoodsType;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取物品类型列表
     *
     * @param paramMap 参数map
     * @return 物品类型列表
     */
    List<GoodsType> getGoodsTypeList(Map<String, Object> paramMap);

}