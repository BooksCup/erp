package com.bc.erp.controller.rc;

import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.RelatedCompanyContactService;
import com.bc.erp.utils.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation(value = "删除往来单位 - 联系人列表", notes = "删除往来单位 - 联系人列表")
    @DeleteMapping(value = "/{rcId}/contact/batch")
    public ResponseEntity<String> deleteRcContact(
            @PathVariable String rcId,
            @RequestParam String contactIds) {
        ResponseEntity<String> responseEntity;
        try {
            List<String> contactIdList = JsonUtil.jsonArrayToList(contactIds, String.class);
            relatedCompanyContactService.deleteRcContactList(contactIdList);
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}