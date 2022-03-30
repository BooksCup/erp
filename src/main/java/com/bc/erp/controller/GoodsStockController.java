package com.bc.erp.controller;

import com.bc.erp.entity.GoodsSpec;
import com.bc.erp.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 物品库存
 *
 * @author zhou
 */
@RestController
@RequestMapping("/goods")
public class GoodsStockController {

    @Resource
    GoodsService goodsService;

    @ApiOperation(value = "获取物品库存", notes = "获取物品库存")
    @GetMapping(value = "/{goodsId}/stock")
    public ResponseEntity<List<GoodsSpec>> getGoodsPageInfo(
            @PathVariable String goodsId) {
        ResponseEntity<List<GoodsSpec>> responseEntity;
        try {
            List<GoodsSpec> goodsSpecList = goodsService.getGoodsSpecListByGoodsId(goodsId);
            responseEntity = new ResponseEntity<>(goodsSpecList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}