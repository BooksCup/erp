package com.bc.erp.mapper;

import com.bc.erp.entity.Project;

import java.util.List;
import java.util.Map;

/**
 * 项目
 *
 * @author zhou
 */
public interface ProjectMapper {

    /**
     * 新增项目
     *
     * @param project 项目
     */
    void addProject(Project project);

    /**
     * 获取项目列表
     *
     * @param paramMap 参数map
     * @return 项目列表
     */
    List<Project> getProjectList(Map<String, Object> paramMap);

}