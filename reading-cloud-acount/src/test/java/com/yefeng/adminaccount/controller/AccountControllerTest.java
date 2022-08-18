package com.yefeng.adminaccount.controller;

import cn.zealon.readingcloud.common.result.Result;
import com.yefeng.adminaccount.bo.UserBO;
import com.yefeng.adminaccount.service.AccountService;
import com.yefeng.adminaccount.vo.AuthVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName AccountControllerTest.java
 * @Description TODO
 * @createTime 2022年07月21日 14:22:00
 */
@SpringBootTest
class AccountControllerTest {

    @Resource
    AccountService accountService;
    @Test
    void login() {
        Result<AuthVO> result = accountService.login("yefeng", "123456");
        System.out.println(result);
    }

    @Test
    void register() {
        UserBO userBO = new UserBO();
        userBO.setLoginName("yefeng");
        userBO.setUserPwd("123456");


        Result result = accountService.addUser(userBO);
        System.out.println(result);
    }
}