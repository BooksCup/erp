package com.bc.erp.service.br.impl.order;

import com.bc.erp.entity.order.Order;
import com.bc.erp.service.br.OrderNoBrHandler;
import com.bc.erp.utils.CommonUtil;
import org.springframework.stereotype.Component;

/**
 * 默认订单号生成规则
 *
 * @author zhou
 */
@Component
public class DefaultOrderNoBrHandler implements OrderNoBrHandler {

    /**
     * 生成订单号
     *
     * @param order 订单
     * @return 订单号
     */
    @Override
    public String getOrderNo(Order order) {
        return CommonUtil.generateId();
    }

}