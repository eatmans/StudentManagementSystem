package com.eatmans.sms.controller;

import com.eatmans.sms.domain.Result;
import com.eatmans.sms.service.UserService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eatmans
 * @version 1.0
 * @date 2021/6/2
 */

@RestController
@RequestMapping("user")
@Api(tags = {"用户模块接口"}, value = "用户模块")
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "手机号码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    public Result<?> login(String userPhone, String password) {
        return userService.login(userPhone, password);
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "userPhone", value = "手机号码", required = true, dataType = "String", paramType = "query")
    @GetMapping("/get")
    public Result<?> get(String userPhone) {
        return userService.getUserByPhone(userPhone);
    }

}
