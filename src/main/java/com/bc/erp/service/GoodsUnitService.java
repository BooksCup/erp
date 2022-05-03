package com.bc.erp.service;

import com.bc.erp.entity.goods.GoodsUnit;

import java.util.List;
import java.util.Map;

/**
 * 物品单位
 *
 * @author zhou
 */
public interface GoodsUnitService {

    /**
     * 新增物品单位
     *
     * @param goodsUnit 物品单位
     */
    void addGoodsUnit(GoodsUnit goodsUnit);

    /**
     * 修改物品单位
     *
     * @param goodsUnit 物品单位
     */
    void updateGoodsUnit(GoodsUnit goodsUnit);

    /**
     * 获取物品单位列表
     *
     * @param paramMap 参数map
     * @return 物品单位列表
     */
    List<GoodsUnit> getGoodsUnitList(Map<String, Object> paramMap);

    /**
     * 删除物品单位
     *
     * @param id 物品单位ID
     */
    void deleteGoodsUnit(String id);

    /**
     * 检查物品单位是否存在
     *
     * @param paramMap 参数map
     * @return true:存在 false:不存在
     */
    boolean checkGoodsUnitExist(Map<String, Object> paramMap);

}