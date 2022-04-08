package com.bc.erp.service;

import com.bc.erp.entity.Goods;
import com.bc.erp.entity.GoodsSpec;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 物品
 *
 * @author zhou
 */
public interface GoodsService {

    /**
     * 新增物品
     *
     * @param goods 物品
     */
    void addGoods(Goods goods);

    /**
     * 修改物品
     *
     * @param goods 物品
     */
    void updateGoods(Goods goods);

    /**
     * 获取物品分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 物品分页信息
     */
    PageInfo<Goods> getGoodsPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);

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

}