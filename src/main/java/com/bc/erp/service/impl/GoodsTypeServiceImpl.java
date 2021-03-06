package com.bc.erp.service.impl;

import com.bc.erp.entity.goods.GoodsType;
import com.bc.erp.mapper.GoodsTypeMapper;
import com.bc.erp.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 物品类型
 *
 * @author zhou
 */
@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Resource
    GoodsTypeMapper goodsTypeMapper;

    /**
     * 新增物品类型
     *
     * @param goodsType 物品类型
     */
    @Override
    public void addGoodsType(GoodsType goodsType) {
        goodsTypeMapper.addGoodsType(goodsType);
    }

    /**
     * 获取物品类型列表
     *
     * @param paramMap 参数map
     * @return 物品类型列表
     */
    @Override
    public List<GoodsType> getGoodsTypeList(Map<String, Object> paramMap) {
        return goodsTypeMapper.getGoodsTypeList(paramMap);
    }

}