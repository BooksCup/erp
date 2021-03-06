package com.bc.erp.mapper;

import com.bc.erp.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
public interface UserMapper {

    /**
     * 根据用户名和密码查找用户
     *
     * @param paramMap 参数map
     * @return 用户
     */
    List<User> getUserByPhoneAndPwd(Map<String, Object> paramMap);

    /**
     * 搜索用户
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> searchUser(Map<String, Object> paramMap);

    /**
     * 更新最后一次登录时间
     *
     * @param paramMap 参数map
     */
    void updateLastLoginTime(Map<String, Object> paramMap);

}