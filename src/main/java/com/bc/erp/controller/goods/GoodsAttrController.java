package com.bc.erp.controller.goods;

import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.GoodsAttrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 物品属性
 *
 * @author zhou
 */
@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsAttrController {

    @Resource
    GoodsAttrService goodsAttrService;

    @ApiOperation(value = "删除物品属性", notes = "删除物品属性")
    @DeleteMapping(value = "/{goodsId}/attrs/{attrId}")
    public ResponseEntity<String> addGoodsType(
            @PathVariable String goodsId,
            @PathVariable String attrId) {
        ResponseEntity<String> responseEntity;
        try {
            goodsAttrService.deleteGoodsAttrById(attrId);
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}