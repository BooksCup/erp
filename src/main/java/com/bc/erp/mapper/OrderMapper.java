package com.bc.erp.mapper;

import com.bc.erp.entity.order.Order;

/**
 * 订单
 *
 * @author zhou
 */
public interface OrderMapper {

    /**
     * 新增订单
     *
     * @param order 订单
     */
    void addOrder(Order order);

}