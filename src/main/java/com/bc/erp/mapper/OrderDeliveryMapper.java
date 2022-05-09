package com.bc.erp.mapper;

import com.bc.erp.entity.order.OrderDelivery;
import com.bc.erp.entity.order.OrderDeliveryDetail;

import java.util.List;
import java.util.Map;

/**
 * 订单交/收货期
 *
 * @author zhou
 */
public interface OrderDeliveryMapper {

    /**
     * 新增交/收货期列表
     *
     * @param orderDeliveryList 交/收货期列表
     */
    void addOrderDeliveryList(List<OrderDelivery> orderDeliveryList);

    /**
     * 获取交/收货期列表
     *
     * @param paramMap 参数map
     * @return 交/收货期列表
     */
    List<OrderDelivery> getOrderDeliveryList(Map<String, Object> paramMap);

    /**
     * 新增交/收货期明细列表
     *
     * @param orderDeliveryDetailList 交/收货期明细列表
     */
    void addOrderDeliveryDetailList(List<OrderDeliveryDetail> orderDeliveryDetailList);

    /**
     * 获取交/收货期明细列表
     *
     * @param paramMap 参数map
     * @return 交/收货期明细列表
     */
    List<OrderDeliveryDetail> getOrderDeliveryDetailList(Map<String, Object> paramMap);

}