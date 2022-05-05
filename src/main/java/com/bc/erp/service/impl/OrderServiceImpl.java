package com.bc.erp.service.impl;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.order.Order;
import com.bc.erp.entity.order.OrderMaterial;
import com.bc.erp.mapper.OrderMapper;
import com.bc.erp.mapper.OrderMaterialMapper;
import com.bc.erp.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 获取订单分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 订单分页信息
     */
    @Override
    public PageInfo<Order> getOrderPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.getOrderList(paramMap);
        return new PageInfo<>(orderList);
    }

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
        Order order = orderMapper.getOrderById(id);
        if (null != order) {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("orderId", id);
            List<OrderMaterial> orderMaterialList = orderMaterialMapper.getOrderMaterialList(paramMap);
            order.setOrderMaterialList(orderMaterialList);
        }
        return order;
    }

}