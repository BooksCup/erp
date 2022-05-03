package com.bc.erp.controller;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.RelatedCompany;
import com.bc.erp.entity.RelatedCompanyAccount;
import com.bc.erp.entity.RelatedCompanyContact;
import com.bc.erp.enums.FlagEnum;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.RelatedCompanyService;
import com.bc.erp.utils.JsonUtil;
import com.github.pagehelper.PageInfo;
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
 * 往来单位
 *
 * @author zhou
 */
@RestController
@CrossOrigin
@RequestMapping("/relatedCompany")
public class RelatedCompanyController {

    @Resource
    RelatedCompanyService relatedCompanyService;

    @ApiOperation(value = "获取往来单位分页信息", notes = "获取往来单位分页信息")
    @GetMapping(value = "/pageInfo")
    public ResponseEntity<PageInfo<RelatedCompany>> getRelatedCompanyPageInfo(
            @RequestParam String enterpriseId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ResponseEntity<PageInfo<RelatedCompany>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("deleteStatus", FlagEnum.FALSE.getCode());
            paramMap.put("keyword", keyword);
            PageInfo<RelatedCompany> pageInfo = relatedCompanyService.getRelatedCompanyPageInfo(paramMap, pageNum, pageSize);
            responseEntity = new ResponseEntity<>(pageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "获取往来单位列表", notes = "获取往来单位列表")
    @GetMapping(value = "")
    public ResponseEntity<List<RelatedCompany>> getRelatedCompanyList(
            @RequestParam String enterpriseId,
            @RequestParam(required = false) String keyword) {
        ResponseEntity<List<RelatedCompany>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("deleteStatus", FlagEnum.FALSE.getCode());
            paramMap.put("keyword", keyword);
            List<RelatedCompany> relatedCompanyList = relatedCompanyService.getRelatedCompanyList(paramMap);
            responseEntity = new ResponseEntity<>(relatedCompanyList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "新增往来单位", notes = "新增往来单位")
    @PostMapping(value = "")
    public ResponseEntity<String> addRelatedCompany(
            @RequestParam String enterpriseId,
            @RequestParam String name,
            @RequestParam String alias,
            @RequestParam(required = false) String logo,
            @RequestParam(required = false) String address,
            @RequestParam String legalPersonName,
            @RequestParam String createId,
            @RequestParam String relatedCompanyContacts,
            @RequestParam String relatedCompanyAccounts) {
        ResponseEntity<String> responseEntity;
        try {
            List<RelatedCompanyContact> relatedCompanyContactList = JsonUtil.jsonArrayToList(relatedCompanyContacts, RelatedCompanyContact.class);
            List<RelatedCompanyAccount> relatedCompanyAccountList = JsonUtil.jsonArrayToList(relatedCompanyAccounts, RelatedCompanyAccount.class);
            RelatedCompany relatedCompany = new RelatedCompany(enterpriseId, name, alias, logo,
                    address, legalPersonName, createId, relatedCompanyContactList, relatedCompanyAccountList);
            relatedCompanyService.addRelatedCompany(relatedCompany);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}