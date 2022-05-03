package com.bc.erp.service.impl;

import com.bc.erp.entity.goods.GoodsUnit;
import com.bc.erp.mapper.GoodsUnitMapper;
import com.bc.erp.service.GoodsUnitService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 物品单位
 *
 * @author zhou
 */
@Service("goodsUnitService")
public class GoodsUnitServiceImpl implements GoodsUnitService {

    @Resource
    GoodsUnitMapper goodsUnitMapper;

    /**
     * 新增物品单位
     *
     * @param goodsUnit 物品单位
     */
    @Override
    public void addGoodsUnit(GoodsUnit goodsUnit) {
        goodsUnitMapper.addGoodsUnit(goodsUnit);
    }

    /**
     * 修改物品单位
     *
     * @param goodsUnit 物品单位
     */
    @Override
    public void updateGoodsUnit(GoodsUnit goodsUnit) {
        goodsUnitMapper.updateGoodsUnit(goodsUnit);
    }

    /**
     * 获取物品单位列表
     *
     * @param paramMap 参数map
     * @return 物品单位列表
     */
    @Override
    public List<GoodsUnit> getGoodsUnitList(Map<String, Object> paramMap) {
        return goodsUnitMapper.getGoodsUnitList(paramMap);
    }

    /**
     * 删除物品单位
     *
     * @param id 物品单位ID
     */
    @Override
    public void deleteGoodsUnit(String id) {
        goodsUnitMapper.deleteGoodsUnit(id);
    }

    /**
     * 检查物品单位是否存在
     *
     * @param paramMap 参数map
     * @return true:存在 false:不存在
     */
    @Override
    public boolean checkGoodsUnitExist(Map<String, Object> paramMap) {
        List<GoodsUnit> goodsUnitList = goodsUnitMapper.getGoodsUnitListByName(paramMap);
        if (CollectionUtils.isEmpty(goodsUnitList)) {
            return false;
        }
        return true;
    }

}