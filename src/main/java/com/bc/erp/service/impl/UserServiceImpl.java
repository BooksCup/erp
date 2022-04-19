package com.bc.erp.service.impl;

import com.bc.erp.entity.User;
import com.bc.erp.mapper.UserMapper;
import com.bc.erp.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
     * 根据用户名和密码查找用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    @Override
    public List<User> getUserByPhoneAndPwd(Map<String, Object> paramMap) {
        return userMapper.getUserByPhoneAndPwd(paramMap);
    }

    /**
     * 搜索用户
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 用户分页信息
     */
    @Override
    public PageInfo<User> searchUser(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.searchUser(paramMap);
        return new PageInfo<>(userList);
    }

    /**
     * 更新最后一次登录时间
     *
     * @param paramMap 参数map
     */
    @Override
    public void updateLastLoginTime(Map<String, Object> paramMap) {
        userMapper.updateLastLoginTime(paramMap);
    }

}