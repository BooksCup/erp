package com.bc.erp.service.impl;

import com.bc.erp.entity.Goods;
import com.bc.erp.entity.Project;
import com.bc.erp.mapper.ProjectMapper;
import com.bc.erp.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 项目
 *
 * @author zhou
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Resource
    ProjectMapper projectMapper;

    /**
     * 新增项目
     *
     * @param project 项目
     */
    @Override
    public void addProject(Project project) {
        projectMapper.addProject(project);
    }

    /**
     * 获取项目分页信息
     *
     * @param paramMap 参数map
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 项目分页信息
     */
    @Override
    public PageInfo<Project> getProjectPageInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Project> projectList = projectMapper.getProjectList(paramMap);
        return new PageInfo<>(projectList);
    }

}