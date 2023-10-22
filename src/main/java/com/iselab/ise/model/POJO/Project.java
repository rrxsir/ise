package com.iselab.ise.model.POJO;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="project")
@ApiModel("轮播图信息")
@EntityListeners(AuditingEntityListener.class)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("论文id")
    private Long id;

    @Column(name="english_version")
    @ApiModelProperty("论文的英文版本")
    private String englishVersion;

    @Column(name="chinese_version")
    @ApiModelProperty("论文的中文版本")
    private String chineseVersion;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, updatable = false, name="create_time")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}
