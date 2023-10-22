package com.iselab.ise.model.DTO.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("修改论文信息")
@Data
public class ProjectEditRequest {
    @ApiModelProperty("论文id")
    private Long id;

    @ApiModelProperty("论文的英文版本")
    private String englishVersion;

    @ApiModelProperty("论文的中文版本")
    private String chineseVersion;
}
