package com.bc.erp.service.br;

import com.bc.erp.cons.Constant;
import com.bc.erp.enums.BrEnum;
import com.bc.erp.service.br.impl.goods.GoodsNoRule0001BrHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理器工厂
 * 生成物料号
 *
 * @author zhou
 */
@Component
public class GoodsNoBrHandlerFactory {

    Map<String, GoodsNoBrHandler> handlerMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);

    /**
     * default handler
     */
    @Resource
    GoodsNoRule0001BrHandler goodsNoRule0001BrHandler;

    @PostConstruct
    public void init() {
        handlerMap.put(BrEnum.GOODS_NO_RULE0001.getCode(), goodsNoRule0001BrHandler);
    }

    public GoodsNoBrHandler getGoodsNoBrHandler(String type) {
        if (StringUtils.isEmpty(type)) {
            return goodsNoRule0001BrHandler;
        }
        GoodsNoBrHandler goodsNoBrHandler = handlerMap.get(type);
        if (null == goodsNoBrHandler) {
            return goodsNoRule0001BrHandler;
        }
        return goodsNoBrHandler;
    }

}