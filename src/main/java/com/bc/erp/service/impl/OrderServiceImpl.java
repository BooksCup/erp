package com.bc.erp.service.impl;

import com.bc.erp.entity.order.Order;
import com.bc.erp.entity.order.OrderMaterial;
import com.bc.erp.mapper.OrderMapper;
import com.bc.erp.mapper.OrderMaterialMapper;
import com.bc.erp.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单
 *
 * @author zhou
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderMaterialMapper orderMaterialMapper;

    /**
     * 新增订单
     *
     * @param order 订单
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder(Order order) {
        orderMapper.addOrder(order);

        List<OrderMaterial> orderMaterialList = order.getOrderMaterialList();
        if (!CollectionUtils.isEmpty(orderMaterialList)) {
            for (OrderMaterial orderMaterial : orderMaterialList) {
                orderMaterial.setOrderId(order.getId());
                orderMaterial.setOrderId(order.getId());
                orderMaterial.setCreateId(order.getCreateId());
            }
            orderMaterialMapper.addOrderMaterialList(order.getOrderMaterialList());
        }
    }

    /**
     * 根据订单ID获取订单信息
     *
     * @param id 订单ID
     * @return 订单信息
     */
    @Override
    public Order getOrderById(String id) {
        return orderMapper.getOrderById(id);
    }

}