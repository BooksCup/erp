package com.bc.erp.service;

import com.bc.erp.entity.stock.StockIn;

/**
 * 入库单
 *
 * @author zhou
 */
public interface StockInService {

    /**
     * 新增入库单
     *
     * @param stockIn 入库单
     */
    void addStockIn(StockIn stockIn);

}