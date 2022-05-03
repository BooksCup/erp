package com.bc.erp.mapper;

import com.bc.erp.entity.order.OrderMaterial;

import java.util.List;

/**
 * 订单材料单
 *
 * @author zhou
 */
public interface OrderMaterialMapper {

    /**
     * 新增材料单列表
     *
     * @param orderMaterialList 材料单列表
     */
    void addOrderMaterialList(List<OrderMaterial> orderMaterialList);

}