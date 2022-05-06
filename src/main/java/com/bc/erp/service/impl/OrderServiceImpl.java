package com.bc.erp.service.impl;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.EnterpriseBr;
import com.bc.erp.entity.order.Order;
import com.bc.erp.entity.order.OrderDelivery;
import com.bc.erp.entity.order.OrderDeliveryDetail;
import com.bc.erp.entity.order.OrderMaterial;
import com.bc.erp.enums.OrderTypeEnum;
import com.bc.erp.mapper.EnterpriseBrMapper;
import com.bc.erp.mapper.OrderDeliveryMapper;
import com.bc.erp.mapper.OrderMapper;
import com.bc.erp.mapper.OrderMaterialMapper;
import com.bc.erp.service.OrderService;
import com.bc.erp.service.br.OrderNoBrHandlerFactory;
import com.bc.erp.utils.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    OrderDeliveryMapper orderDeliveryMapper;

    @Resource
    OrderNoBrHandlerFactory orderNoBrHandlerFactory;

    @Resource
    EnterpriseBrMapper enterpriseBrMapper;

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
        EnterpriseBr enterpriseBr = enterpriseBrMapper.getEnterpriseBr(order.getEnterpriseId());
        String orderNo = "";
        if (OrderTypeEnum.SALES_ORDER.getCode().equals(order.getType())) {
            orderNo = orderNoBrHandlerFactory.
                    getOrderNoBrHandler(enterpriseBr == null ? "" : enterpriseBr.getSalesOrderNoRule()).getOrderNo(order);
        }
        order.setNo(orderNo);
        orderMapper.addOrder(order);

        List<OrderMaterial> orderMaterialList = order.getOrderMaterialList();
        if (!CollectionUtils.isEmpty(orderMaterialList)) {
            for (OrderMaterial orderMaterial : orderMaterialList) {
                orderMaterial.setId(CommonUtil.generateId());
                orderMaterial.setOrderId(order.getId());
                orderMaterial.setCreateId(order.getCreateId());
            }
            orderMaterialMapper.addOrderMaterialList(order.getOrderMaterialList());
        }

        List<OrderDelivery> orderDeliveryList = order.getOrderDeliveryList();
        List<OrderDeliveryDetail> orderDeliveryDetailList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(orderDeliveryList)) {
            for (OrderDelivery orderDelivery : orderDeliveryList) {
                String deliveryId = CommonUtil.generateId();
                orderDelivery.setId(deliveryId);
                orderDelivery.setOrderId(order.getId());
                orderDelivery.setCreateId(order.getCreateId());
                List<OrderDeliveryDetail> detailList = orderDelivery.getOrderDeliveryDetailList();
                if (!CollectionUtils.isEmpty(detailList)) {
                    for (OrderDeliveryDetail detail : detailList) {
                        detail.setId(CommonUtil.generateId());
                        detail.setDeliveryId(deliveryId);
                    }
                    orderDeliveryDetailList.addAll(detailList);
                }
            }
            orderDeliveryMapper.addOrderDeliveryList(orderDeliveryList);
        }
        if (!CollectionUtils.isEmpty(orderDeliveryDetailList)) {
            orderDeliveryMapper.addOrderDeliveryDetailList(orderDeliveryDetailList);
        }

    }

    /**
     * 新增订单列表
     *
     * @param enterpriseId 企业ID
     * @param parentId     父订单ID
     * @param orderList    订单列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrderList(String enterpriseId, String parentId, List<Order> orderList) {
        EnterpriseBr enterpriseBr = enterpriseBrMapper.getEnterpriseBr(enterpriseId);
        if (!CollectionUtils.isEmpty(orderList)) {
            List<OrderMaterial> orderMaterialList = new ArrayList<>();
            for (Order order : orderList) {
                order.setId(CommonUtil.generateId());
                order.setParentId(parentId);
                order.setEnterpriseId(enterpriseId);
                String orderNo = "";
                if (OrderTypeEnum.SALES_ORDER.getCode().equals(order.getType())) {
                    orderNo = orderNoBrHandlerFactory.
                            getOrderNoBrHandler(enterpriseBr == null ? "" : enterpriseBr.getSalesOrderNoRule()).getOrderNo(order);
                } else if (OrderTypeEnum.PURCHASE_ORDER.getCode().equals(order.getType())) {
                    orderNo = orderNoBrHandlerFactory.
                            getOrderNoBrHandler(enterpriseBr == null ? "" : enterpriseBr.getPurchaseOrderNoRule()).getOrderNo(order);
                }
                order.setNo(orderNo);
                OrderMaterial orderMaterial = new OrderMaterial(parentId, order.getGoodsId(), order.getId());
                orderMaterial.setStatus("1");
                orderMaterialList.add(orderMaterial);
            }
            orderMapper.addOrderList(orderList);
            orderMaterialMapper.updateOrderMaterialListForPurchase(orderMaterialList);
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