package com.bc.erp.service.impl;

import com.bc.erp.entity.User;
import com.bc.erp.mapper.UserMapper;
import com.bc.erp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    /**
     * 根据用户名和密码查找用户
     *
     * @param paramMap 参数map
     * @return 用户
     */
    @Override
    public User getUserByPhoneAndPwd(Map<String, Object> paramMap) {
        return userMapper.getUserByPhoneAndPwd(paramMap);
    }

}