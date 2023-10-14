package com.iselab.ise.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页请求")
public class PageRequest {

    @ApiModelProperty("页码")
    private int page;

    @ApiModelProperty("每页记录数")
    private int pageSize;

    @ApiModelProperty("分类,可选参数")
    private Integer category;

}
