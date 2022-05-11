package com.bc.erp.mapper;

import com.bc.erp.entity.order.Order;

import java.util.List;
import java.util.Map;

/**
 * 订单
 *
 * @author zhou
 */
public interface OrderMapper {

    /**
     * 获取订单列表
     *
     * @param paramMap 参数map
     * @return 订单列表
     */
    List<Order> getOrderList(Map<String, Object> paramMap);

    /**
     * 根据父订单ID和物品类型获取订单列表
     *
     * @param paramMap 参数map
     * @return 订单列表
     */
    List<Order> getOrderListByParentIdAndGoodsType(Map<String, Object> paramMap);

    /**
     * 新增订单
     *
     * @param order 订单
     */
    void addOrder(Order order);

    /**
     * 新增订单列表
     *
     * @param orderList 订单列表
     */
    void addOrderList(List<Order> orderList);

    /**
     * 根据订单ID获取订单信息
     *
     * @param id 订单ID
     * @return 订单信息
     */
    Order getOrderById(String id);

    /**
     * 根据订单ID删除订单
     *
     * @param id 订单ID
     */
    void deleteOrderById(String id);

}