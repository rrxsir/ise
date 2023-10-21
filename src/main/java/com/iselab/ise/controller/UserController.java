package com.iselab.ise.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.iselab.ise.common.Result;
import com.iselab.ise.model.DTO.user.LoginDTO;
import com.iselab.ise.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户登录与注册")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Result<?> register(LoginDTO loginDTO) {
        log.info("用户注册: {}", loginDTO.getUsername());
        userService.register(loginDTO);
        return Result.success("注册成功");
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Result<?> login(LoginDTO loginDTO) {
        log.info("用户登录: {}", loginDTO);
        userService.login(loginDTO);
        return Result.success("登录成功");
    }

    @ApiOperation(value = "获取当前登录用户的token信息")
    @GetMapping("/tokenInfo")
    public Result<?> tokenInfo() {
        return Result.success(StpUtil.getTokenInfo());
    }

    @ApiOperation(value = "用户登出")
    @GetMapping("/logout")
    public Result<?> logout() {
        StpUtil.logout();
        return Result.success("登出成功");
    }
}
