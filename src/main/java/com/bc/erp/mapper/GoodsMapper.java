package com.bc.erp.mapper;

import com.bc.erp.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * 物品
 *
 * @author zhou
 */
public interface GoodsMapper {

    /**
     * 新增物品
     *
     * @param goods 物品
     */
    void addGoods(Goods goods);

    /**
     * 获取物品列表
     *
     * @param paramMap 参数map
     * @return 物品列表
     */
    List<Goods> getGoodsList(Map<String, Object> paramMap);

}