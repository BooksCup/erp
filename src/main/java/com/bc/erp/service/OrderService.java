package com.bc.erp.service;

import com.bc.erp.entity.order.Order;

/**
 * 订单
 *
 * @author zhou
 */
public interface OrderService {

    /**
     * 新增订单
     *
     * @param order 订单
     */
    void addOrder(Order order);

}