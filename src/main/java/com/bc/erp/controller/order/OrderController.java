package com.bc.erp.controller.order;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.order.Order;
import com.bc.erp.entity.order.OrderDelivery;
import com.bc.erp.entity.order.OrderMaterial;
import com.bc.erp.enums.FlagEnum;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.OrderService;
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
 * 订单
 *
 * @author zhou
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Resource
    OrderService orderService;

    @ApiOperation(value = "获取订单分页信息", notes = "获取订单分页信息")
    @GetMapping(value = "/pageInfo")
    public ResponseEntity<PageInfo<Order>> getGoodsPageInfo(
            @RequestParam String enterpriseId,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam String types) {
        ResponseEntity<PageInfo<Order>> responseEntity;
        try {
            List<String> typeList = JsonUtil.jsonArrayToList(types, String.class);
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("deleteStatus", FlagEnum.FALSE.getCode());
            paramMap.put("typeList", typeList);
            PageInfo<Order> pageInfo = orderService.getOrderPageInfo(paramMap, pageNum, pageSize);
            responseEntity = new ResponseEntity<>(pageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "新增订单", notes = "新增订单")
    @PostMapping(value = "")
    public ResponseEntity<String> addOrder(
            @RequestParam String enterpriseId,
            @RequestParam String type,
            @RequestParam String rcId,
            @RequestParam(required = false) String rcContactId,
            @RequestParam String goodsId,
            @RequestParam String projectId,
            @RequestParam String orderMaterials,
            @RequestParam String orderDeliverys,
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            List<OrderMaterial> orderMaterialList = JsonUtil.jsonArrayToList(orderMaterials, OrderMaterial.class);
            List<OrderDelivery> orderDeliveryList = JsonUtil.jsonArrayToList(orderDeliverys, OrderDelivery.class);
            Order order = new Order(enterpriseId, type, rcId, rcContactId, goodsId,
                    projectId, createId, orderMaterialList, orderDeliveryList);
            orderService.addOrder(order);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "批量新增订单", notes = "批量新增订单")
    @PostMapping(value = "/batch")
    public ResponseEntity<String> addOrderList(
            @RequestParam String enterpriseId,
            @RequestParam(required = false) String parentId,
            @RequestParam String orders) {
        ResponseEntity<String> responseEntity;
        try {
            List<Order> orderList = JsonUtil.jsonArrayToList(orders, Order.class);
            orderService.addOrderList(enterpriseId, parentId, orderList);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "根据订单ID获取订单信息", notes = "根据订单ID获取订单信息")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrderById(
            @PathVariable String id) {
        ResponseEntity<Order> responseEntity;
        try {
            Order order = orderService.getOrderById(id);
            responseEntity = new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new Order(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "根据订单ID删除订单", notes = "根据订单ID删除订单")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteOrderById(
            @PathVariable String id) {
        ResponseEntity<String> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}