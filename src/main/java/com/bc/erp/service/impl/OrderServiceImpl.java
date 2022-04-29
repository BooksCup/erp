package com.bc.erp.service.impl;

import com.bc.erp.entity.order.Order;
import com.bc.erp.mapper.OrderMapper;
import com.bc.erp.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单
 *
 * @author zhou
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    /**
     * 新增订单
     *
     * @param order 订单
     */
    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

}