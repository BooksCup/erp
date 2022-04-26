package com.bc.erp.service.impl;

import com.bc.erp.entity.stock.StockIn;
import com.bc.erp.mapper.StockInMapper;
import com.bc.erp.service.StockInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 入库单
 *
 * @author zhou
 */
@Service("stockInService")
public class StockInServiceImpl implements StockInService {

    @Resource
    StockInMapper stockInMapper;

    /**
     * 新增入库单
     *
     * @param stockIn 入库单
     */
    @Override
    public void addStockIn(StockIn stockIn) {
        stockInMapper.addStockIn(stockIn);
    }

}