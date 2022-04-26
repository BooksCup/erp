package com.bc.erp.mapper;

import com.bc.erp.entity.stock.StockIn;

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

}