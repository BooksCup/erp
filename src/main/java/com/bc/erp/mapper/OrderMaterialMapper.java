package com.bc.erp.mapper;

import com.bc.erp.entity.order.OrderMaterial;

import java.util.List;
import java.util.Map;

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

    /**
     * 修改材料单列表
     *
     * @param orderMaterialList 材料单列表
     */
    void updateOrderMaterialList(List<OrderMaterial> orderMaterialList);

    /**
     * 获取材料单列表
     *
     * @param paramMap 参数map
     * @return 材料单列表
     */
    List<OrderMaterial> getOrderMaterialList(Map<String, Object> paramMap);

    /**
     * 采购更新材料单列表
     *
     * @param orderMaterialList 材料单列表
     */
    void updateOrderMaterialListForPurchase(List<OrderMaterial> orderMaterialList);

}