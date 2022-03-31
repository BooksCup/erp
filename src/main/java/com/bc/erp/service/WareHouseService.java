package com.bc.erp.service;

import com.bc.erp.entity.WareHouse;

import java.util.List;
import java.util.Map;

/**
 * 仓库
 *
 * @author zhou
 */
public interface WareHouseService {

    /**
     * 新增仓库
     *
     * @param wareHouse 仓库
     */
    void addWareHouse(WareHouse wareHouse);

    /**
     * 获取仓库列表
     *
     * @param paramMap 参数map
     * @return 仓库列表
     */
    List<WareHouse> getWareHouseList(Map<String, Object> paramMap);

}