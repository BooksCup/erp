package com.bc.erp.controller.stock;

import com.bc.erp.entity.stock.StockIn;
import com.bc.erp.entity.stock.StockInDetail;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.StockInService;
import com.bc.erp.utils.JsonUtil;
import io.swagger.annotations.ApiOperation;
import net.sf.json.util.JSONUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 入库单
 *
 * @author zhou
 */
@RestController
@RequestMapping("/stockIn")
@CrossOrigin
public class StockInController {

    @Resource
    StockInService stockInService;

    @ApiOperation(value = "新增入库单", notes = "新增入库单")
    @PostMapping(value = "")
    public ResponseEntity<String> addStockIn(
            @RequestParam String enterpriseId,
            @RequestParam String wareHouseId,
            @RequestParam String type,
            @RequestParam String entryDate,
            @RequestParam(required = false) String relatedCompanyId,
            @RequestParam(required = false) String remark,
            @RequestParam(required = false) String photos,
            @RequestParam String stockInDetails,
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            List<StockInDetail> stockInDetailList = JsonUtil.jsonArrayToList(stockInDetails, StockInDetail.class);
            StockIn stockIn = new StockIn(enterpriseId, wareHouseId, type, relatedCompanyId,
                    remark, photos, entryDate, createId, stockInDetailList);
            stockInService.addStockIn(stockIn);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}