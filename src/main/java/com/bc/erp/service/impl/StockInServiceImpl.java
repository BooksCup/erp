package com.bc.erp.service.impl;

import com.bc.erp.entity.stock.StockIn;
import com.bc.erp.entity.stock.StockInDetail;
import com.bc.erp.mapper.StockInMapper;
import com.bc.erp.service.StockInService;
import com.bc.erp.utils.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    @Transactional(rollbackFor = Exception.class)
    public void addStockIn(StockIn stockIn) {
        stockInMapper.addStockIn(stockIn);

        List<StockInDetail> stockInDetailList = stockIn.getStockInDetailList();
        for (StockInDetail stockInDetail : stockInDetailList) {
            stockInDetail.setId(CommonUtil.generateId());
            stockInDetail.setStockInId(stockIn.getId());
            stockInDetail.setEnterpriseId(stockIn.getEnterpriseId());
        }
        stockInMapper.addStockInDetailList(stockInDetailList);
    }

}