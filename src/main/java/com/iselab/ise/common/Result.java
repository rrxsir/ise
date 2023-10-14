package com.iselab.ise.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("通用返回结果")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("响应状态码")
    private Integer code;   // 1:成功  0或其它表示失败

    @ApiModelProperty("响应信息")
    private String msg;     // 错误信息

    @ApiModelProperty("响应数据")
    private T data;     // 数据

    public static <T> Result<T> success(T object) {
        return new Result<>(1, object, "");
    }

    public static <T> Result<T> success() {
        return new Result<>(1, null, "");
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(0, null, msg);
    }

    public static <T> Result<T> error(ErrorCode errorCode) {
        return new Result<T>(errorCode.getCode(), null, errorCode.getMessage());
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, null, message);
    }

    public static <T> Result<T> error(ErrorCode errorCode, String message) {
        return new Result<>(errorCode.getCode(), null, message);
    }

    public Result(int code, T data, String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Result(int code, T data){
        this(code,data,"");
    }

    public Result(ErrorCode errorCode){
        this(errorCode.getCode(),null,errorCode.getMessage());
    }
}
