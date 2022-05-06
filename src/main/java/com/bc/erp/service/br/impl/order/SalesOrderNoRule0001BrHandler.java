package com.bc.erp.service.br.impl.order;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.order.Order;
import com.bc.erp.enums.BrEnum;
import com.bc.erp.service.br.OrderNoBrHandler;

import com.bc.erp.entity.Goods;
import com.bc.erp.entity.Sn;
import com.bc.erp.enums.GoodsTypeEnum;
import com.bc.erp.mapper.GoodsMapper;
import com.bc.erp.mapper.SnMapper;
import com.bc.erp.utils.CommonUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 销售订单号生成规则:0001
 * 年(yy) + symbol +月(MM) + 序列号(补齐两位数)
 * eg:22ZGG0301
 *
 * @author zhou
 */
@Component
public class SalesOrderNoRule0001BrHandler implements OrderNoBrHandler {

    private static final int MIN_INT_DIGITS = 2;

    @Resource
    SnMapper snMapper;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String yearField = new SimpleDateFormat("YY").format(new Date());
        String monthField = new SimpleDateFormat("MM").format(new Date());
        Goods goods = goodsMapper.getGoodsById(order.getGoodsId());
        String orderNo = "";
        // 销售订单
        String symbol;
        String no;
        if (null == goods) {
            symbol = GoodsTypeEnum.UD.getOrderSymbol();
        } else {
            symbol = GoodsTypeEnum.getOrderSymbolByName(goods.getTypeName());
        }
        Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
        paramMap.put("rule", BrEnum.SALES_ORDER_NO_RULE0001.getCode());
        paramMap.put("code", symbol);

        Sn sn = snMapper.getSn(paramMap);
        if (null == sn) {
            no = CommonUtil.fillNumWithZero(1, MIN_INT_DIGITS);
            sn = new Sn(BrEnum.SALES_ORDER_NO_RULE0001.getCode(), symbol, 1, CommonUtil.now());
            snMapper.addSn(sn);
        } else {
            Calendar currentCal = Calendar.getInstance();
            currentCal.setTime(new Date());
            int currentMonth = currentCal.get(Calendar.MONTH);

            // 每个月更新一次
            Date snDate = null;
            try {
                snDate = sdf.parse(sn.getModifyTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(snDate);
            int month = cal.get(Calendar.MONTH);
            if (currentMonth == month) {
                no = CommonUtil.fillNumWithZero(sn.getSn() + 1, MIN_INT_DIGITS);
                sn = new Sn(BrEnum.SALES_ORDER_NO_RULE0001.getCode(), symbol, sn.getSn() + 1, CommonUtil.now());
            } else {
                no = CommonUtil.fillNumWithZero(1, MIN_INT_DIGITS);
                sn = new Sn(BrEnum.SALES_ORDER_NO_RULE0001.getCode(), symbol, 1, CommonUtil.now());
            }
            snMapper.updateSn(sn);
        }
        orderNo = yearField + symbol + monthField + no;
        return orderNo;
    }

}