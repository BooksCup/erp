package com.bc.erp.controller.goods;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.goods.GoodsType;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.GoodsTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物品类型
 *
 * @author zhou
 */
@RestController
@RequestMapping("/goodsType")
@CrossOrigin
public class GoodsTypeController {

    @Resource
    GoodsTypeService goodsTypeService;

    @ApiOperation(value = "新增物品类型", notes = "新增物品类型")
    @PostMapping(value = "")
    public ResponseEntity<String> addGoodsType(
            @RequestParam String enterpriseId,
            @RequestParam String name,
            @RequestParam String symbol,
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            GoodsType goodsType = new GoodsType(enterpriseId, name, symbol, createId);
            goodsTypeService.addGoodsType(goodsType);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "获取物品类型列表", notes = "获取物品类型列表")
    @GetMapping(value = "")
    public ResponseEntity<List<GoodsType>> getGoodsTypeList(
            @RequestParam String enterpriseId) {
        ResponseEntity<List<GoodsType>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            List<GoodsType> goodsTypeList = goodsTypeService.getGoodsTypeList(paramMap);
            responseEntity = new ResponseEntity<>(goodsTypeList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}