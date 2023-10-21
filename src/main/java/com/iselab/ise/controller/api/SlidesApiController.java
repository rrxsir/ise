package com.iselab.ise.controller.api;

import com.iselab.ise.common.Result;
import com.iselab.ise.model.DTO.slides.SlidesAddRequest;
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

    @ApiOperation(value = "获取所有轮播图")
    @GetMapping("/getSlides")
    public Result<?> getSlides() {
        return Result.success(slidesService.getAllSlides());
    }

    @ApiOperation(value = "获取所有轮播图（分页）")
    @GetMapping("/getSlidesByPage")
    public Result<?> getSlidesByPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return Result.success(slidesService.getAllSlides(pageable));
    }

    @ApiOperation(value = "添加轮播图")
    @PostMapping("/insertSlides")
    public Result<?> insertSlides(SlidesAddRequest slidesAddRequest) {
        Slides slides = new Slides();
        BeanUtils.copyProperties(slidesAddRequest, slides);
        return Result.success(slidesService.addSlides(slides));
    }

    @ApiOperation(value = "修改轮播图")
    @PostMapping("/updateSlides")
    public Result<?> updateSlides(SlidesAddRequest slidesAddRequest) {
        Slides slides = new Slides();
        BeanUtils.copyProperties(slidesAddRequest, slides);
        return Result.success(slidesService.updateSlides(slides));
    }


    @ApiOperation(value = "删除轮播图")
    @PostMapping("/deleteSlides")
    public Result<?> deleteSlides(Long id) {
        return Result.success(slidesService.deleteSlides(id));
    }
}
