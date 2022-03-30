package com.bc.erp.service;

import com.bc.erp.entity.Goods;
import com.github.pagehelper.PageInfo;

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
     * 获取物品分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 物品分页信息
     */
    PageInfo<Goods> getGoodsPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);

}