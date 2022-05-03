package com.bc.erp.controller.order;

import com.bc.erp.entity.order.Order;
import com.bc.erp.entity.order.OrderMaterial;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.OrderService;
import com.bc.erp.utils.JsonUtil;
import com.bc.erp.utils.OrderUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    OrderUtil orderUtil;

    @ApiOperation(value = "新增订单", notes = "新增订单")
    @PostMapping(value = "")
    public ResponseEntity<String> addOrder(
            @RequestParam String enterpriseId,
            @RequestParam String type,
            @RequestParam String rcId,
            @RequestParam(required = false) String rcContactId,
            @RequestParam String po,
            @RequestParam String goodsId,
            @RequestParam String orderMaterials,
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            List<OrderMaterial> orderMaterialList = JsonUtil.jsonArrayToList(orderMaterials, OrderMaterial.class);
            Order order = new Order(enterpriseId, type, rcId, rcContactId, po, goodsId, createId, orderMaterialList);
            String orderNo = orderUtil.getOrderNo(order);
            order.setNo(orderNo);
            orderService.addOrder(order);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "根据订单ID获取订单信息", notes = "根据订单ID获取订单信息")
    @PostMapping(value = "/{id}")
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

}