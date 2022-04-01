package com.bc.erp.service;

import com.bc.erp.entity.User;

import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
public interface UserService {

    /**
     * 根据用户名和密码查找用户
     *
     * @param paramMap 参数map
     * @return 用户
     */
    User getUserByPhoneAndPwd(Map<String, Object> paramMap);

}