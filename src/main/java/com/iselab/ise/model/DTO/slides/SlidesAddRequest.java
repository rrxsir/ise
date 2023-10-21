package com.iselab.ise.model.DTO.slides;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("添加轮播图信息")
@Data
public class SlidesAddRequest {

    @ApiModelProperty("图片链接到的地址")
    private String url;

    @ApiModelProperty("图片封面地址")
    private String cover;
}
