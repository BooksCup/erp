package com.bc.erp.service.br;

import com.bc.erp.entity.Goods;

/**
 * 业务规则处理器
 *
 * @author zhou
 */
public interface GoodsNoBrHandler {

    /**
     * 生成物料号
     *
     * @param goods 物品
     * @return 物料号
     */
    String getGoodsNo(Goods goods);

}