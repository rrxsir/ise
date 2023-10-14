package com.iselab.ise.exception;


import cn.dev33.satoken.exception.NotLoginException;
import com.iselab.ise.common.ErrorCode;
import com.iselab.ise.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return Result.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }

    /**
     * 如果是请求资源，需要在header中添加“axios-request”，然后会返回一个RestBean
     * 如果是直接get，则会重定向到登录页面
     * @param e NotLoginException
     * @return 没登陆或者直接跳转
     */
    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result<?> handlerNotLoginException(NotLoginException e){
//        System.out.println("Not Login Handler is working !");
//        HttpServletRequest request = RequestHolder.getRequest();
//        String axiosRequest = request.getHeader("axios-request");
//        System.out.println(axiosRequest);
//        if(axiosRequest == null || !axiosRequest.isEmpty()){
//            return Result.error(ResultCode.USER_NOTLOGGED_IN);
//        }
        log.info(e.getMessage());
        return Result.error(ErrorCode.NOT_LOGIN_ERROR, "用户未登录");

    }
}
