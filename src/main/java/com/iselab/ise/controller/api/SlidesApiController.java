package com.iselab.ise.controller.api;

import com.iselab.ise.common.Result;
import com.iselab.ise.model.DTO.slides.SlidesAddRequest;
import com.iselab.ise.model.DTO.slides.SlidesEditRequest;
import com.iselab.ise.model.POJO.Slides;
import com.iselab.ise.service.SlidesService;
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

@Api(tags = "轮播图后台api")
@RestController
@RequestMapping("/slides")
@Slf4j
public class SlidesApiController {
    private final SlidesService slidesService;

    public SlidesApiController(SlidesService slidesService) {
        this.slidesService = slidesService;
    }

    @ApiOperation(value = "获取所有")
    @GetMapping("/getAll")
    public Result<?> getAll() {
        return Result.success(slidesService.getAll());
    }

    @ApiOperation(value = "获取所有（分页）")
    @GetMapping("/getByPage")
    public Result<?> getByPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return Result.success(slidesService.getAll(pageable));
    }

    @ApiOperation(value = "添加")
    @PostMapping("/insert")
    public Result<?> insert(SlidesAddRequest slidesAddRequest) {
        Slides slides = new Slides();
        BeanUtils.copyProperties(slidesAddRequest, slides);
        return Result.success(slidesService.add(slides));
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result<?> update(SlidesEditRequest slidesEditRequest) {
        Slides slides = new Slides();
        BeanUtils.copyProperties(slidesEditRequest, slides);
        return Result.success(slidesService.update(slides));
    }


    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public Result<?> delete(Long id) {
        return Result.success(slidesService.delete(id));
    }
}
