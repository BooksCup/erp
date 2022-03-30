package com.bc.erp.controller;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.Goods;
import com.bc.erp.entity.GoodsSpec;
import com.bc.erp.enums.FlagEnum;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.GoodsService;
import com.bc.erp.utils.JsonUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物品
 *
 * @author zhou
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @ApiOperation(value = "新增物品", notes = "新增物品")
    @PostMapping(value = "")
    public ResponseEntity<String> addGoods(
            @RequestParam String enterpriseId,
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam String attrs,
            @RequestParam String specX,
            @RequestParam(required = false) String specY,
            @RequestParam String specs,
            @RequestParam String photos,
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            List<GoodsSpec> goodsSpecList = JsonUtil.jsonArrayToList(specs, GoodsSpec.class);
            Goods goods = new Goods(enterpriseId, name, photos, type, specX, specY, goodsSpecList, createId);
            goodsService.addGoods(goods);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "获取物品分页信息", notes = "获取物品分页信息")
    @GetMapping(value = "/pageInfo")
    public ResponseEntity<PageInfo<Goods>> getGoodsPageInfo(
            @RequestParam String enterpriseId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ResponseEntity<PageInfo<Goods>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("deleteStatus", FlagEnum.FALSE.getCode());
            paramMap.put("keyword", keyword);
            PageInfo<Goods> pageInfo = goodsService.getGoodsPageInfo(paramMap, pageNum, pageSize);
            responseEntity = new ResponseEntity<>(pageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}