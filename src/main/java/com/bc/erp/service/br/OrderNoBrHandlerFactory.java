package com.bc.erp.service.br;

import com.bc.erp.cons.Constant;
import com.bc.erp.enums.BrEnum;
import com.bc.erp.service.br.impl.order.DefaultOrderNoBrHandler;
import com.bc.erp.service.br.impl.order.PurchaseOrderNoRule0001BrHandler;
import com.bc.erp.service.br.impl.order.SalesOrderNoRule0001BrHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理器工厂
 * 生成订单号
 *
 * @author zhou
 */
@Component
public class OrderNoBrHandlerFactory {

    Map<String, OrderNoBrHandler> handlerMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);

    /**
     * default handler
     */
    @Resource
    DefaultOrderNoBrHandler defaultOrderNoBrHandler;

    @Resource
    SalesOrderNoRule0001BrHandler salesOrderNoRule0001BrHandler;

    @Resource
    PurchaseOrderNoRule0001BrHandler purchaseOrderNoRule0001BrHandler;

    @PostConstruct
    public void init() {
        handlerMap.put(BrEnum.SALES_ORDER_NO_RULE0001.getCode(), salesOrderNoRule0001BrHandler);
        handlerMap.put(BrEnum.PURCHASE_ORDER_NO_RULE0001.getCode(), purchaseOrderNoRule0001BrHandler);
    }

    public OrderNoBrHandler getOrderNoBrHandler(String type) {
        if (StringUtils.isEmpty(type)) {
            return defaultOrderNoBrHandler;
        }
        OrderNoBrHandler orderNoBrHandler = handlerMap.get(type);
        if (null == orderNoBrHandler) {
            return defaultOrderNoBrHandler;
        }
        return orderNoBrHandler;
    }

}