package com.bc.erp.service.br.impl.order;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.Goods;
import com.bc.erp.entity.order.Order;
import com.bc.erp.enums.GoodsTypeEnum;
import com.bc.erp.mapper.GoodsMapper;
import com.bc.erp.mapper.OrderMapper;
import com.bc.erp.service.br.OrderNoBrHandler;
import com.bc.erp.utils.CommonUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采购订单号生成规则:0001
 * 父订单号 + symbol
 * eg:22ZGG0301-J
 *
 * @author zhou
 */
@Component
public class PurchaseOrderNoRule0001BrHandler implements OrderNoBrHandler {

    @Resource
    OrderMapper orderMapper;

    @Resource
    GoodsMapper goodsMapper;

    /**
     * 生成订单号
     *
     * @param order 订单
     * @return 订单号
     */
    @Override
    public String getOrderNo(Order order) {
        String orderNo;
        if (!StringUtils.isEmpty(order.getParentId())) {
            Order parentOrder = orderMapper.getOrderById(order.getParentId());
            Goods goods = goodsMapper.getGoodsById(order.getGoodsId());
            // 查找是否有相同类型的订单
            String symbol = StringUtils.isEmpty(goods.getTypeSymbol()) ? GoodsTypeEnum.UD.getOrderSymbol() : goods.getTypeSymbol();
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("parentId", order.getParentId());
            paramMap.put("symbol", symbol);
            List<Order> orderList = orderMapper.getOrderListByParentIdAndGoodsType(paramMap);
            if (CollectionUtils.isEmpty(orderList)) {
                orderNo = parentOrder.getNo() + "-" + symbol;
            } else {
                int index = orderList.size() + 1;
                orderNo = parentOrder.getNo() + "-" + symbol + "-" + index;
            }
        } else {
            orderNo = CommonUtil.generateId();
        }
        return orderNo;
    }

}