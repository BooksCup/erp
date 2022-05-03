package com.bc.erp.controller.goods;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.goods.GoodsUnit;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.GoodsUnitService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物品单位
 *
 * @author zhou
 */
@RestController
@RequestMapping("/goodsUnit")
@CrossOrigin
public class GoodsUnitController {

    @Resource
    GoodsUnitService goodsUnitService;

    @ApiOperation(value = "新增物品单位", notes = "新增物品单位")
    @PostMapping(value = "")
    public ResponseEntity<String> addGoodsUnit(
            @RequestParam String enterpriseId,
            @RequestParam String name,
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("name", name);
            if (goodsUnitService.checkGoodsUnitExist(paramMap)) {
                return new ResponseEntity<>(ResponseMsg.ALREADY_EXISTS.getCode(), HttpStatus.BAD_REQUEST);
            }
            GoodsUnit goodsUnit = new GoodsUnit(enterpriseId, name, createId);
            goodsUnitService.addGoodsUnit(goodsUnit);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "修改物品单位", notes = "修改物品单位")
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateGoodsUnit(
            @PathVariable String id,
            @RequestParam String enterpriseId,
            @RequestParam String name) {
        ResponseEntity<String> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("id", id);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("name", name);
            if (goodsUnitService.checkGoodsUnitExist(paramMap)) {
                return new ResponseEntity<>(ResponseMsg.ALREADY_EXISTS.getCode(), HttpStatus.BAD_REQUEST);
            }
            GoodsUnit goodsUnit = new GoodsUnit();
            goodsUnit.setId(id);
            goodsUnit.setName(name);
            goodsUnitService.updateGoodsUnit(goodsUnit);
            responseEntity = new ResponseEntity<>(ResponseMsg.UPDATE_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.UPDATE_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "获取物品单位列表", notes = "获取物品单位列表")
    @GetMapping(value = "")
    public ResponseEntity<List<GoodsUnit>> getGoodsUnitList(
            @RequestParam String enterpriseId) {
        ResponseEntity<List<GoodsUnit>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            List<GoodsUnit> goodsUnitList = goodsUnitService.getGoodsUnitList(paramMap);
            responseEntity = new ResponseEntity<>(goodsUnitList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "删除物品单位", notes = "删除物品单位")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteGoodsUnit(
            @PathVariable String id) {
        ResponseEntity<String> responseEntity;
        try {
            goodsUnitService.deleteGoodsUnit(id);
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}