package com.bc.erp.controller;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.User;
import com.bc.erp.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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
    @GetMapping(value = "/loginByPwd")
    public ResponseEntity<User> login(
            @RequestParam String phone,
            @RequestParam String password) {
        ResponseEntity<User> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("phone", phone);
            paramMap.put("password", password);
            User user = userService.getUserByPhoneAndPwd(paramMap);
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}