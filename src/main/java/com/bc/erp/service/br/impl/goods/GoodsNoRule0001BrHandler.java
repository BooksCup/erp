package com.bc.erp.service.br.impl.goods;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.Goods;
import com.bc.erp.entity.Sn;
import com.bc.erp.entity.goods.GoodsType;
import com.bc.erp.enums.BrEnum;
import com.bc.erp.enums.GoodsTypeEnum;
import com.bc.erp.mapper.GoodsTypeMapper;
import com.bc.erp.mapper.SnMapper;
import com.bc.erp.service.br.GoodsNoBrHandler;
import com.bc.erp.utils.CommonUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 物料号生成规则:0001
 * 年(yy) + 月(MM) + symbol + 序列号(补齐三位数)
 * eg:2205F001
 *
 * @author zhou
 */
@Component
public class GoodsNoRule0001BrHandler implements GoodsNoBrHandler {

    @Resource
    GoodsTypeMapper goodsTypeMapper;

    @Resource
    SnMapper snMapper;

    /**
     * 生成物料号
     *
     * @param goods 物品
     * @return 物料号
     */
    @Override
    public synchronized String getGoodsNo(Goods goods) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String yearField = new SimpleDateFormat("YY").format(new Date());
        String monthField = new SimpleDateFormat("MM").format(new Date());
        GoodsType goodsType = goodsTypeMapper.getGoodsTypeById(goods.getTypeId());
        Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
        String symbol = null == goodsType || StringUtils.isEmpty(goodsType.getSymbol())
                ? GoodsTypeEnum.UD.getCode() : goodsType.getSymbol();
        paramMap.put("rule", BrEnum.GOODS_NO_RULE0001.getCode());
        paramMap.put("code", symbol);
        Sn sn = snMapper.getSn(paramMap);
        String no;
        if (null == sn) {
            no = CommonUtil.geFourNumber(1);
            sn = new Sn(BrEnum.GOODS_NO_RULE0001.getCode(), symbol, 1, CommonUtil.now());
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
                no = CommonUtil.geFourNumber(sn.getSn() + 1);
                sn = new Sn(BrEnum.GOODS_NO_RULE0001.getCode(), symbol, sn.getSn() + 1, CommonUtil.now());
            } else {
                no = CommonUtil.geFourNumber(1);
                sn = new Sn(BrEnum.GOODS_NO_RULE0001.getCode(), symbol, 1, CommonUtil.now());
            }
            snMapper.updateSn(sn);
        }
        return yearField + monthField + symbol + no;
    }

}