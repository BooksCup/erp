package com.bc.erp.mapper;

import com.bc.erp.entity.stock.StockIn;
import com.bc.erp.entity.stock.StockInDetail;

import java.util.List;

/**
 * 入库单
 *
 * @author zhou
 */
public interface StockInMapper {

    /**
     * 新增入库单
     *
     * @param stockIn 入库单
     */
    void addStockIn(StockIn stockIn);

    /**
     * 新增入库单详情列表
     *
     * @param stockInDetailList 入库单详情列表
     */
    void addStockInDetailList(List<StockInDetail> stockInDetailList);

}