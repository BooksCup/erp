package com.bc.erp.service.br;

import com.bc.erp.entity.Goods;
import com.bc.erp.entity.order.Order;

/**
 * 业务规则处理器
 * 生成订单号
 *
 * @author zhou
 */
public interface OrderNoBrHandler {

    /**
     * 生成订单号
     *
     * @param order 订单
     * @return 订单号
     */
    String getOrderNo(Order order);

}