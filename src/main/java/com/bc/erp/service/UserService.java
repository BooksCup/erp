package com.bc.erp.service;

import com.bc.erp.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
public interface UserService {

    /**
     * 根据用户名和密码查找用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> getUserByPhoneAndPwd(Map<String, Object> paramMap);

    /**
     * 搜索用户
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 用户分页信息
     */
    PageInfo<User> searchUser(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);

    /**
     * 更新最后一次登录时间
     *
     * @param paramMap 参数map
     */
    void updateLastLoginTime(Map<String, Object> paramMap);

}