package com.bc.erp.mapper;

import com.bc.erp.entity.Goods;
import com.bc.erp.entity.GoodsSpec;

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

    /**
     * 根据物品ID获取物品规格列表
     *
     * @param goodsId 物品ID
     * @return 物品规格列表
     */
    List<GoodsSpec> getGoodsSpecListByGoodsId(String goodsId);

    /**
     * 根据物品ID获取物品详情
     *
     * @param goodsId 物品ID
     * @return 物品详情
     */
    Goods getGoodsById(String goodsId);

    /**
     * 更新商品
     * @param goods 商品
     */
    void updateGoods(Goods goods);

    /**
     * 更新商品标签
     * @param paramMap 参数map
     */
    void updateGoodsTags(Map<String, Object> paramMap);

}