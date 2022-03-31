package com.bc.erp.service.impl;

import com.bc.erp.entity.WareHouse;
import com.bc.erp.mapper.WareHouseMapper;
import com.bc.erp.service.WareHouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 物品
 *
 * @author zhou
 */
@Service("wareHouseService")
public class WareHouseServiceImpl implements WareHouseService {

    @Resource
    WareHouseMapper wareHouseMapper;

    /**
     * 新增仓库
     *
     * @param wareHouse 仓库
     */
    @Override
    public void addWareHouse(WareHouse wareHouse) {
        wareHouseMapper.addWareHouse(wareHouse);
    }

    /**
     * 获取仓库列表
     *
     * @param paramMap 参数map
     * @return 仓库列表
     */
    @Override
    public List<WareHouse> getWareHouseList(Map<String, Object> paramMap) {
        return wareHouseMapper.getWareHouseList(paramMap);
    }

}