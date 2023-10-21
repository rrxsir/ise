package com.iselab.ise.model.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Data
@Table(name="slides")
@ApiModel("轮播图信息")
@EntityListeners(AuditingEntityListener.class)
public class Slides {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("轮播图id")
    private Long id;

    @Column(name="url")
    @ApiModelProperty("图片链接到的地址")
    private String url;

    @Column(name="cover")
    @ApiModelProperty("图片封面地址")
    private String cover;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, updatable = false, name="create_time")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}
