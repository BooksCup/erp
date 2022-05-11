package com.bc.erp.service.impl;

import com.bc.erp.entity.EnterpriseBr;
import com.bc.erp.entity.Goods;
import com.bc.erp.entity.GoodsAttr;
import com.bc.erp.entity.GoodsSpec;
import com.bc.erp.enums.BrEnum;
import com.bc.erp.mapper.EnterpriseBrMapper;
import com.bc.erp.mapper.GoodsAttrMapper;
import com.bc.erp.mapper.GoodsMapper;
import com.bc.erp.mapper.GoodsSpecMapper;
import com.bc.erp.service.GoodsService;
import com.bc.erp.service.br.GoodsNoBrHandlerFactory;
import com.bc.erp.utils.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    GoodsAttrMapper goodsAttrMapper;

    @Resource
    GoodsSpecMapper goodsSpecMapper;

    @Resource
    GoodsNoBrHandlerFactory goodsNoBrHandlerFactory;

    @Resource
    EnterpriseBrMapper enterpriseBrMapper;

    /**
     * 新增物品
     *
     * @param goods 物品
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addGoods(Goods goods) {
        EnterpriseBr enterpriseBr = enterpriseBrMapper.getEnterpriseBr(goods.getEnterpriseId());
        String goodsNo = goodsNoBrHandlerFactory.
                getGoodsNoBrHandler(enterpriseBr == null ? "" : enterpriseBr.getGoodsNoRule()).getGoodsNo(goods);
        goods.setNo(goodsNo);
        goodsMapper.addGoods(goods);

        // 物品属性
        if (!CollectionUtils.isEmpty(goods.getGoodsAttrList())) {
            int sort = 1;
            for (GoodsAttr goodsAttr : goods.getGoodsAttrList()) {
                goodsAttr.setEnterpriseId(goods.getEnterpriseId());
                goodsAttr.setSort(sort);
                goodsAttr.setGoodsId(goods.getId());
                goodsAttr.setId(CommonUtil.generateId());
                sort++;
            }
            goodsAttrMapper.addGoodsAttrList(goods.getGoodsAttrList());
        }

        // 物品规格
        if (!CollectionUtils.isEmpty(goods.getGoodsSpecList())) {
            int sort = 1;
            for (GoodsSpec goodsSpec : goods.getGoodsSpecList()) {
                goodsSpec.setEnterpriseId(goods.getEnterpriseId());
                goodsSpec.setSort(sort);
                goodsSpec.setGoodsId(goods.getId());
                goodsSpec.setId(CommonUtil.generateId());
                sort++;
            }
            goodsSpecMapper.addGoodsSpecList(goods.getGoodsSpecList());
        }

    }

    /**
     * 修改物品
     *
     * @param goods 物品
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGoods(Goods goods) {

        goodsMapper.updateGoods(goods);

        List<GoodsAttr> goodsAttrList = goods.getGoodsAttrList();
        List<GoodsAttr> addAttrList = new ArrayList<>();
        List<GoodsAttr> updateAttrList = new ArrayList<>();
        // 物品属性
        if (!CollectionUtils.isEmpty(goodsAttrList)) {
            int sort = 1;
            for (GoodsAttr attr : goodsAttrList) {
                attr.setSort(sort);
                if (StringUtils.isEmpty(attr.getId())) {
                    attr.setId(CommonUtil.generateId());
                    attr.setEnterpriseId(goods.getEnterpriseId());
                    addAttrList.add(attr);
                } else {
                    updateAttrList.add(attr);
                }
                sort++;
            }
        }
        if (!CollectionUtils.isEmpty(addAttrList)) {
            goodsAttrMapper.addGoodsAttrList(addAttrList);
        }
        if (!CollectionUtils.isEmpty(updateAttrList)) {
            goodsAttrMapper.updateGoodsAttrList(updateAttrList);
        }

        List<GoodsSpec> goodsSpecList = goods.getGoodsSpecList();
        List<GoodsSpec> addSpecList = new ArrayList<>();
        List<GoodsSpec> updateSpecList = new ArrayList<>();
        // 物品属性
        if (!CollectionUtils.isEmpty(goodsSpecList)) {
            int sort = 1;
            for (GoodsSpec spec : goodsSpecList) {
                spec.setSort(sort);
                if (StringUtils.isEmpty(spec.getId())) {
                    spec.setId(CommonUtil.generateId());
                    spec.setEnterpriseId(goods.getEnterpriseId());
                    addSpecList.add(spec);
                } else {
                    updateSpecList.add(spec);
                }
                sort++;
            }
        }
        if (!CollectionUtils.isEmpty(addSpecList)) {
            goodsSpecMapper.addGoodsSpecList(addSpecList);
        }
        if (!CollectionUtils.isEmpty(updateSpecList)) {
            goodsSpecMapper.updateGoodsSpecList(updateSpecList);
        }

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

    /**
     * 根据物品ID获取物品规格列表
     *
     * @param goodsId 物品ID
     * @return 物品规格列表
     */
    @Override
    public List<GoodsSpec> getGoodsSpecListByGoodsId(String goodsId) {
        return goodsSpecMapper.getGoodsSpecListByGoodsId(goodsId);
    }

    /**
     * 根据物品ID获取物品详情
     *
     * @param goodsId 物品ID
     * @return 物品详情
     */
    @Override
    public Goods getGoodsById(String goodsId) {
        Goods goods = goodsMapper.getGoodsById(goodsId);
        if (null != goods) {
            List<GoodsAttr> goodsAttrList = goodsAttrMapper.getGoodsAttrListByGoodsId(goodsId);
            List<GoodsSpec> goodsSpecList = goodsSpecMapper.getGoodsSpecListByGoodsId(goodsId);
            goods.setGoodsAttrList(goodsAttrList);
            goods.setGoodsSpecList(goodsSpecList);
        }
        return goods;
    }

    /**
     * 更新商品标签
     *
     * @param paramMap 参数map
     */
    @Override
    public void updateGoodsTags(Map<String, Object> paramMap) {
        goodsMapper.updateGoodsTags(paramMap);
    }

}