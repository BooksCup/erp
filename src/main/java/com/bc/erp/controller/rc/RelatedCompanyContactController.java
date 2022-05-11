package com.bc.erp.controller.rc;

import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.RelatedCompanyContactService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 往来单位 - 联系人
 *
 * @author zhou
 */
@RestController
@CrossOrigin
@RequestMapping("/relatedCompany")
public class RelatedCompanyContactController {

    @Resource
    RelatedCompanyContactService relatedCompanyContactService;

    @ApiOperation(value = "删除往来单位 - 联系人", notes = "删除往来单位 - 联系人")
    @DeleteMapping(value = "/{rcId}/contact/{contactId}")
    public ResponseEntity<String> deleteRcContact(
            @PathVariable String rcId,
            @PathVariable String contactId) {
        ResponseEntity<String> responseEntity;
        try {
            relatedCompanyContactService.deleteRcContact(contactId);
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}