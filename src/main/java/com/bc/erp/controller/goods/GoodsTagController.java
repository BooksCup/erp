package com.bc.erp.controller.goods;

import com.alibaba.fastjson.JSONObject;
import com.bc.erp.cons.Constant;
import com.bc.erp.entity.Goods;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.GoodsService;
import com.bc.erp.utils.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物品标签
 *
 * @author zhou
 */
@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsTagController {

    @Resource
    GoodsService goodsService;

    @ApiOperation(value = "删除物品标签", notes = "删除物品标签")
    @DeleteMapping(value = "/{goodsId}/tags/{tag}")
    public ResponseEntity<String> addGoodsType(
            @PathVariable String goodsId,
            @PathVariable String tag) {
        ResponseEntity<String> responseEntity;
        try {
            Goods goods = goodsService.getGoodsById(goodsId);
            List<String> tagList = JsonUtil.jsonArrayToList(goods.getTags(), String.class);
            if (!CollectionUtils.isEmpty(tagList)) {
                tagList.remove(tag);
            }
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("goodsId", goods.getId());
            paramMap.put("tags", JSONObject.toJSONString(tagList));
            goodsService.updateGoodsTags(paramMap);
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}