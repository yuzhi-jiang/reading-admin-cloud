package com.yefeng.adminaccount.service;

import cn.zealon.readingcloud.common.pojo.account.User;
import cn.zealon.readingcloud.common.result.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yefeng.adminaccount.bo.UserBO;
import com.yefeng.adminaccount.vo.AuthVO;

public interface AccountService extends IService<User> {
    Result<AuthVO> login(String username, String password);


    Result addUser(UserBO userBO);
}
