package com.bc.erp.controller.order;

import com.bc.erp.entity.order.Order;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.OrderService;
import com.bc.erp.utils.OrderUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            Order order = new Order(enterpriseId, type, rcId, rcContactId, po, goodsId, createId);
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

}