package com.bc.erp.utils;

import com.bc.erp.entity.Goods;
import com.bc.erp.entity.Sn;
import com.bc.erp.entity.order.Order;
import com.bc.erp.enums.GoodsTypeEnum;
import com.bc.erp.enums.OrderTypeEnum;
import com.bc.erp.mapper.GoodsMapper;
import com.bc.erp.mapper.SnMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 订单工具类
 *
 * @author zhou
 */
@Component
public class OrderUtil {

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    SnMapper snMapper;

    public String getOrderNo(Order order) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String yearField = new SimpleDateFormat("YY").format(new Date());
        String monthField = new SimpleDateFormat("MM").format(new Date());
        Calendar currentCal = Calendar.getInstance();
        currentCal.setTime(new Date());
        int currentMonth = currentCal.get(Calendar.MONTH);

        Goods goods = goodsMapper.getGoodsById(order.getGoodsId());
        String orderNo = "";
        if (OrderTypeEnum.SALES_ORDER.getCode().equals(order.getType())) {
            // 销售订单
            String orderSymbol;
            String no;
            if (null == goods) {
                orderSymbol = GoodsTypeEnum.UD.getOrderSymbol();
            } else {
                orderSymbol = GoodsTypeEnum.getOrderSymbolByName(goods.getTypeName());
            }
            Sn sn = snMapper.getSn(orderSymbol);
            if (null == sn) {
                no = CommonUtil.geFourNumber(1);
                sn = new Sn(orderSymbol, currentMonth, 1, CommonUtil.now());
                snMapper.addSn(sn);
            } else {
                // 每个月更新一次
                Date snDate = sdf.parse(sn.getModifyTime());
                Calendar cal = Calendar.getInstance();
                cal.setTime(snDate);
                int month = cal.get(Calendar.MONTH);
                if (currentMonth == month) {
                    no = CommonUtil.geFourNumber(sn.getSn() + 1);
                    sn = new Sn(orderSymbol, currentMonth, sn.getSn() + 1, CommonUtil.now());
                } else {
                    no = CommonUtil.geFourNumber(1);
                    sn = new Sn(orderSymbol, currentMonth, 1, CommonUtil.now());
                }
                snMapper.updateSn(sn);
            }
            orderNo = yearField + orderSymbol + monthField + no;
        }
//        else if (OrderTypeEnum.PURCHASE_ORDER.getCode().equals(order.getType())){
//            // 采购订单
//        }
        return orderNo;
    }


}