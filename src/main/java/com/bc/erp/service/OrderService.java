package com.bc.erp.service;

import com.bc.erp.entity.order.Order;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 订单
 *
 * @author zhou
 */
public interface OrderService {

    /**
     * 获取订单分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 订单分页信息
     */
    PageInfo<Order> getOrderPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);

    /**
     * 新增订单
     *
     * @param order 订单
     */
    void addOrder(Order order);

    /**
     * 新增订单列表
     *
     * @param enterpriseId 企业ID
     * @param parentId     父订单ID
     * @param orderList    订单列表
     */
    void addOrderList(String enterpriseId, String parentId, List<Order> orderList);

    /**
     * 根据订单ID获取订单信息
     *
     * @param id 订单ID
     * @return 订单信息
     */
    Order getOrderById(String id);

}