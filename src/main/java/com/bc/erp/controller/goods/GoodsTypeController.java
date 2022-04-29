package com.bc.erp.controller.goods;

import com.bc.erp.entity.goods.GoodsType;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.GoodsTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

}