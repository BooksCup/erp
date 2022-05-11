package com.bc.erp.controller.rc;

import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.RelatedCompanyAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 往来单位 - 账户
 *
 * @author zhou
 */
@RestController
@CrossOrigin
@RequestMapping("/relatedCompany")
public class RelatedCompanyAccountController {

    @Resource
    RelatedCompanyAccountService relatedCompanyAccountService;

    @ApiOperation(value = "删除往来单位 - 账户", notes = "删除往来单位 - 账户")
    @DeleteMapping(value = "/{rcId}/account/{accountId}")
    public ResponseEntity<String> deleteRcAccount(
            @PathVariable String rcId,
            @PathVariable String accountId) {
        ResponseEntity<String> responseEntity;
        try {
            relatedCompanyAccountService.deleteRcAccount(accountId);
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}