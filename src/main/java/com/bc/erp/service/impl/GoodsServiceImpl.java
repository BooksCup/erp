package com.bc.erp.service.impl;

import com.bc.erp.entity.Goods;
import com.bc.erp.mapper.GoodsMapper;
import com.bc.erp.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 物品
 *
 * @author zhou
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    /**
     * 新增物品
     *
     * @param goods 物品
     */
    @Override
    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }

    /**
     * 获取物品分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 物品分页信息
     */
    @Override
    public PageInfo<Goods> getGoodsPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goodsList = goodsMapper.getGoodsList(paramMap);
        return new PageInfo<>(goodsList);
    }

}