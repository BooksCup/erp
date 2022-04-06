package com.bc.erp.mapper;

import com.bc.erp.entity.WareHouse;

import java.util.List;
import java.util.Map;

/**
 * 仓库
 *
 * @author zhou
 */
public interface WareHouseMapper {

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

    /**
     * 获取子仓库数量
     *
     * @param wareHouseId 仓库ID
     * @return 子仓库数量
     */
    Integer getChildWareHouseCount(String wareHouseId);

    /**
     * 更新子仓库数量
     *
     * @param paramMap 参数map
     */
    void updateChildWareHouseCount(Map<String, Object> paramMap);

}