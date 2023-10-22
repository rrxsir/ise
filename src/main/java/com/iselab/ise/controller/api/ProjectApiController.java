package com.iselab.ise.controller.api;

import com.iselab.ise.common.Result;
import com.iselab.ise.model.DTO.project.ProjectAddRequest;
import com.iselab.ise.model.DTO.project.ProjectEditRequest;
import com.iselab.ise.model.POJO.Project;
import com.iselab.ise.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "论文后台api")
@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectApiController {
    private final ProjectService projectService;

    public ProjectApiController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("/getAll")
    public Result<?> getAll() {
        return Result.success(projectService.getAll());
    }

    @ApiOperation(value = "获取所有（分页）")
    @GetMapping("/getByPage")
    public Result<?> getByPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return Result.success(projectService.getAll(pageable));
    }

    @ApiOperation(value = "添加")
    @PostMapping("/insert")
    public Result<?> insert(ProjectAddRequest projectAddRequest) {
        Project project = new Project();
        BeanUtils.copyProperties(projectAddRequest, project);
        return Result.success(projectService.add(project));
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result<?> update(ProjectEditRequest projectEditRequest) {
        Project project = new Project();
        BeanUtils.copyProperties(projectEditRequest, project);
        return Result.success(projectService.update(project));
    }


    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public Result<?> delete(Long id) {
        return Result.success(projectService.delete(id));
    }
}
