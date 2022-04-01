package com.bc.erp.controller;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.WareHouse;
import com.bc.erp.enums.FlagEnum;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.WareHouseService;
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
 * 仓库
 *
 * @author zhou
 */
@RestController
@CrossOrigin
@RequestMapping("/wareHouse")
public class WareHouseController {

    @Resource
    WareHouseService wareHouseService;

    @ApiOperation(value = "新增仓库", notes = "新增仓库")
    @PostMapping(value = "")
    public ResponseEntity<String> addWareHouse(
            @RequestParam String enterpriseId,
            @RequestParam String userId,
            @RequestParam String parentId,
            @RequestParam String name,
            @RequestParam String contactName,
            @RequestParam String contactPhone,
            @RequestParam String province,
            @RequestParam String city,
            @RequestParam String address,
            @RequestParam String remark,
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            WareHouse wareHouse = new WareHouse(enterpriseId, userId, parentId, name,
                    contactName, contactPhone, province, city, address, remark, createId);
            wareHouseService.addWareHouse(wareHouse);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "获取仓库列表信息", notes = "获取仓库列表信息")
    @GetMapping(value = "")
    public ResponseEntity<List<WareHouse>> getWareHouseList(
            @RequestParam String enterpriseId,
            @RequestParam(required = false, defaultValue = "0") String parentId) {
        ResponseEntity<List<WareHouse>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("deleteStatus", FlagEnum.FALSE.getCode());
            paramMap.put("parentId", parentId);
            List<WareHouse> wareHouseList = wareHouseService.getWareHouseList(paramMap);
            responseEntity = new ResponseEntity<>(wareHouseList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}