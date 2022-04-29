package com.bc.erp.service;

import com.bc.erp.entity.Project;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * 项目
 *
 * @author zhou
 */
public interface ProjectService {

    /**
     * 新增项目
     *
     * @param project 项目
     */
    void addProject(Project project);

    /**
     * 获取项目分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 项目分页信息
     */
    PageInfo<Project> getProjectPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);

}