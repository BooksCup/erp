package com.bc.erp.service.impl;

import com.bc.erp.mapper.GoodsAttrMapper;
import com.bc.erp.service.GoodsAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 物品属性
 *
 * @author zhou
 */
@Service("goodsAttrService")
public class GoodsAttrServiceImpl implements GoodsAttrService {

    @Resource
    GoodsAttrMapper goodsAttrMapper;

    /**
     * 根据属性ID删除属性
     *
     * @param attrId 属性ID
     */
    @Override
    public void deleteGoodsAttrById(String attrId) {
        goodsAttrMapper.deleteGoodsAttrById(attrId);
    }

}