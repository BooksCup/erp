package com.bc.erp.controller;

import com.bc.erp.cons.Constant;
import com.bc.erp.entity.Project;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.ProjectService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目
 *
 * @author zhou
 */
@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

    @Resource
    ProjectService projectService;

    @ApiOperation(value = "新增项目", notes = "新增项目")
    @PostMapping(value = "")
    public ResponseEntity<String> addProject(
            @RequestParam String enterpriseId,
            @RequestParam String name,
            @RequestParam String createId) {
        ResponseEntity<String> responseEntity;
        try {
            Project project = new Project(enterpriseId, name, createId);
            projectService.addProject(project);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_SUCCESS.getCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @ApiOperation(value = "获取项目分页信息", notes = "获取项目分页信息")
    @GetMapping(value = "/pageInfo")
    public ResponseEntity<PageInfo<Project>> getProjectPageInfo(
            @RequestParam String enterpriseId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ResponseEntity<PageInfo<Project>> responseEntity;
        try {
            if (!StringUtils.isEmpty(keyword)) {
                keyword = keyword.trim();
            }
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("enterpriseId", enterpriseId);
            paramMap.put("keyword", keyword);
            PageInfo<Project> pageInfo = projectService.getProjectPageInfo(paramMap, pageNum, pageSize);
            responseEntity = new ResponseEntity<>(pageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}