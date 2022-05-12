package com.bc.erp.service.impl;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.EnterpriseBr;
import com.bc.erp.entity.GoodsSpec;
import com.bc.erp.entity.order.Order;
import com.bc.erp.entity.order.OrderDelivery;
import com.bc.erp.entity.order.OrderDeliveryDetail;
import com.bc.erp.entity.order.OrderMaterial;
import com.bc.erp.enums.OrderTypeEnum;
import com.bc.erp.enums.PriceMethodEnum;
import com.bc.erp.mapper.*;
import com.bc.erp.service.OrderService;
import com.bc.erp.service.br.OrderNoBrHandlerFactory;
import com.bc.erp.utils.BigDecimalUtil;
import com.bc.erp.utils.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

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

    @Resource
    GoodsSpecMapper goodsSpecMapper;

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
                orderMaterial.setEnterpriseId(order.getEnterpriseId());
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
                orderDelivery.setEnterpriseId(order.getEnterpriseId());
                List<OrderDeliveryDetail> detailList = orderDelivery.getOrderDeliveryDetailList();
                if (!CollectionUtils.isEmpty(detailList)) {
                    for (OrderDeliveryDetail detail : detailList) {
                        detail.setId(CommonUtil.generateId());
                        detail.setOrderId(order.getId());
                        detail.setDeliveryId(deliveryId);
                        detail.setEnterpriseId(order.getEnterpriseId());
                    }
                    orderDeliveryDetailList.addAll(detailList);
                }
            }
            orderDeliveryMapper.addOrderDeliveryList(orderDeliveryList);
        }

        if (!CollectionUtils.isEmpty(orderDeliveryDetailList)) {
            orderDeliveryDetailList = getPriceFromOrder(order, orderDeliveryDetailList);
            orderDeliveryMapper.addOrderDeliveryDetailList(orderDeliveryDetailList);
        }

    }

    /**
     * 修改订单
     *
     * @param order 订单
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);

        // 材料单
        List<OrderMaterial> orderMaterialList = order.getOrderMaterialList();
        List<OrderMaterial> addMaterialList = new ArrayList<>();
        List<OrderMaterial> updateMaterialList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(orderMaterialList)) {
            for (OrderMaterial orderMaterial : orderMaterialList) {
                if (StringUtils.isEmpty(orderMaterial.getId())) {
                    orderMaterial.setId(CommonUtil.generateId());
                    orderMaterial.setOrderId(order.getId());
                    orderMaterial.setEnterpriseId(order.getEnterpriseId());
                    addMaterialList.add(orderMaterial);
                } else {
                    updateMaterialList.add(orderMaterial);
                }
            }
        }
        if (!CollectionUtils.isEmpty(addMaterialList)) {
            orderMaterialMapper.addOrderMaterialList(addMaterialList);
        }
        if (!CollectionUtils.isEmpty(updateMaterialList)) {
            orderMaterialMapper.updateOrderMaterialList(updateMaterialList);
        }

        List<OrderDelivery> orderDeliveryList = order.getOrderDeliveryList();
        List<OrderDelivery> addDeliveryList = new ArrayList<>();
        List<OrderDelivery> updateDeliveryList = new ArrayList<>();
        List<OrderDeliveryDetail> addDeliveryDetailList = new ArrayList<>();
        List<OrderDeliveryDetail> updateDeliveryDetailList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(orderDeliveryList)) {
            for (OrderDelivery orderDelivery : orderDeliveryList) {
                if (StringUtils.isEmpty(orderDelivery.getId())) {
                    String deliveryId = CommonUtil.generateId();
                    orderDelivery.setId(deliveryId);
                    orderDelivery.setOrderId(order.getId());
                    orderDelivery.setCreateId(order.getCreateId());
                    orderDelivery.setEnterpriseId(order.getEnterpriseId());
                    List<OrderDeliveryDetail> detailList = orderDelivery.getOrderDeliveryDetailList();
                    if (!CollectionUtils.isEmpty(detailList)) {
                        for (OrderDeliveryDetail detail : detailList) {
                            detail.setId(CommonUtil.generateId());
                            detail.setOrderId(order.getId());
                            detail.setDeliveryId(deliveryId);
                            detail.setEnterpriseId(order.getEnterpriseId());
                        }
                        addDeliveryDetailList.addAll(detailList);
                    }
                    addDeliveryList.add(orderDelivery);
                } else {
                    updateDeliveryList.add(orderDelivery);
                    List<OrderDeliveryDetail> detailList = orderDelivery.getOrderDeliveryDetailList();
                    if (!CollectionUtils.isEmpty(detailList)) {
                        for (OrderDeliveryDetail detail : detailList) {
                            if (StringUtils.isEmpty(detail.getId())) {
                                detail.setId(CommonUtil.generateId());
                                detail.setOrderId(order.getId());
                                detail.setDeliveryId(orderDelivery.getId());
                                detail.setEnterpriseId(order.getEnterpriseId());
                                addDeliveryDetailList.add(detail);
                            } else {
                                updateDeliveryDetailList.add(detail);
                            }
                        }
                    }
                }
            }
        }
        if (!CollectionUtils.isEmpty(addDeliveryList)) {
            orderDeliveryMapper.addOrderDeliveryList(addDeliveryList);
        }
        if (!CollectionUtils.isEmpty(updateDeliveryList)) {
            orderDeliveryMapper.updateOrderDeliveryList(updateDeliveryList);
        }
        if (!CollectionUtils.isEmpty(addDeliveryDetailList)) {
            addDeliveryDetailList = getPriceFromOrder(order, addDeliveryDetailList);
            orderDeliveryMapper.addOrderDeliveryDetailList(addDeliveryDetailList);
        }
        if (!CollectionUtils.isEmpty(updateDeliveryDetailList)) {
            updateDeliveryDetailList = getPriceFromOrder(order, updateDeliveryDetailList);
            orderDeliveryMapper.updateOrderDeliveryDetailList(updateDeliveryDetailList);
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
                orderMapper.addOrder(order);
            }
//            orderMapper.addOrderList(orderList);
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
            List<GoodsSpec> goodsSpecList = goodsSpecMapper.getGoodsSpecListByGoodsId(order.getGoodsId());
            order.setGoodsSpecList(goodsSpecList);

            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("orderId", id);
            List<OrderMaterial> orderMaterialList = orderMaterialMapper.getOrderMaterialList(paramMap);
            order.setOrderMaterialList(orderMaterialList);

            List<OrderDelivery> orderDeliveryList = orderDeliveryMapper.getOrderDeliveryList(paramMap);
            List<OrderDeliveryDetail> orderDeliveryDetailList = orderDeliveryMapper.getOrderDeliveryDetailList(paramMap);
            Map<String, List<OrderDeliveryDetail>> map = new LinkedHashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            for (OrderDelivery orderDelivery : orderDeliveryList) {
                map.put(orderDelivery.getId(), new ArrayList<>());
            }
            for (OrderDeliveryDetail detail : orderDeliveryDetailList) {
                List<OrderDeliveryDetail> detailList = map.get(detail.getDeliveryId());
                detailList.add(detail);
                map.put(detail.getDeliveryId(), detailList);
            }
            for (OrderDelivery orderDelivery : orderDeliveryList) {
                List<OrderDeliveryDetail> detailList = map.get(orderDelivery.getId());
                orderDelivery.setOrderDeliveryDetailList(detailList);
            }
            order.setOrderDeliveryList(orderDeliveryList);

        }
        return order;
    }

    /**
     * 根据订单ID删除订单
     *
     * @param id 订单ID
     */
    @Override
    public void deleteOrderById(String id) {
        orderMapper.deleteOrderById(id);
    }

    /**
     * 获取订单价格
     *
     * @param order                   订单
     * @param orderDeliveryDetailList 订单交期详情列表
     * @return 订单交期详情列表
     */
    private List<OrderDeliveryDetail> getPriceFromOrder(Order order, List<OrderDeliveryDetail> orderDeliveryDetailList) {
        // 填充价格
        if (PriceMethodEnum.AVERAGE_PRICE.getCode().equals(order.getPriceMethod())) {
            for (OrderDeliveryDetail detail : orderDeliveryDetailList) {
                detail.setPrice(new BigDecimalUtil().object2BigDecimal(order.getPriceData()));
            }
        }
        return orderDeliveryDetailList;
    }

}