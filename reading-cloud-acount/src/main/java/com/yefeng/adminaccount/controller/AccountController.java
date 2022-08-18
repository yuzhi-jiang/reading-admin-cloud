package com.yefeng.adminaccount.controller;

import cn.zealon.readingcloud.common.request.RequestParams;
import cn.zealon.readingcloud.common.result.Result;
import com.yefeng.adminaccount.bo.UserBO;
import com.yefeng.adminaccount.service.AccountService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName AccountController.java
 * @Description TODO
 * @createTime 2022年07月16日 20:29:00
 */
@Api(value = "管理员接口")
@RestController
//@RequestMapping("admin")
public class AccountController {


    @Resource
    AccountService accountService;

//    登录接口
    @ApiOperation(value = "登录接口" , httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 200, message = "", response = String.class)})
    @PostMapping("/login")
    public Result login(@RequestBody RequestParams params) {
        String loginName = params.getStringValue("loginName");
        String password = params.getStringValue("password");
        return accountService.login(loginName, password);
    }

    //    注册接口
    @ApiOperation(value = "添加用户接口" , httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 200, message = "", response = String.class)})
    @PostMapping("/addUser")
    public Result register(@RequestBody UserBO userBO) {
        return accountService.addUser(userBO);
    }


}
