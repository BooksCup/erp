package com.bc.erp.controller;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.User;
import com.bc.erp.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping(value = "/loginByPwd")
    public ResponseEntity<User> login(
            @RequestParam String phone,
            @RequestParam String password) {
        ResponseEntity<User> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("phone", phone);
            paramMap.put("password", password);
            List<User> userList = userService.getUserByPhoneAndPwd(paramMap);
            if (CollectionUtils.isEmpty(userList)) {
                responseEntity = new ResponseEntity<>(new User(), HttpStatus.BAD_REQUEST);
            } else {
                User user = userList.get(0);
                paramMap.clear();
                paramMap.put("userId", user.getId());
                userService.updateLastLoginTime(paramMap);
                responseEntity = new ResponseEntity<>(userList.get(0), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "搜索用户", notes = "搜索用户")
    @GetMapping(value = "/search")
    public ResponseEntity<PageInfo<User>> searchUser(
            @RequestParam String enterpriseId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ResponseEntity<PageInfo<User>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("name", name);
            paramMap.put("phone", phone);
            PageInfo<User> userList = userService.searchUser(paramMap, pageNum, pageSize);
            responseEntity = new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}