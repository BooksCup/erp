package com.bc.erp.mapper;

import com.bc.erp.entity.Sn;

import java.util.Map;

/**
 * 序列号
 *
 * @author zhou
 */
public interface SnMapper {

    /**
     * 获取序列号
     *
     * @param paramMap 参数map(包含规则和模块编码)
     * @return 序列号
     */
    Sn getSn(Map<String, Object> paramMap);

    /**
     * 新增序列号
     *
     * @param sn 序列号
     */
    void addSn(Sn sn);

    /**
     * 修改序列号
     *
     * @param sn 序列号
     */
    void updateSn(Sn sn);

}