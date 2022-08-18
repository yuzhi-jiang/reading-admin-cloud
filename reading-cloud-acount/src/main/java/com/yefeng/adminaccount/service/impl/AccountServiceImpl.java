package com.yefeng.adminaccount.service.impl;

import cn.zealon.readingcloud.common.pojo.account.User;
import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.common.result.ResultUtil;

import cn.zealon.readingcloud.common.utils.CommonUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.adminaccount.bo.UserBO;
import com.yefeng.adminaccount.service.AccountService;
import com.yefeng.adminaccount.utils.JwtUtil;
import com.yefeng.adminaccount.utils.UserUtil;
import com.yefeng.adminaccount.vo.AuthVO;
import com.yefeng.adminaccount.dao.AccountMapper;
import com.yefeng.adminaccount.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

import static cn.zealon.readingcloud.common.constant.JwtConstant.EXPIRE_DAY;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName AccountServiceImpl.java
 * @Description TODO
 * @createTime 2022年07月16日 21:18:00
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, User> implements AccountService {
    @Resource
    AccountMapper mapper;
    Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Override
    public Result addUser(UserBO userBO) {
        User dbUser = this.mapper.selectByLoginName(userBO.getLoginName());
        if (dbUser != null) {
            return ResultUtil.verificationFailed().buildMessage(userBO.getLoginName() + "已存在，请使用其它登录名进行注册！");
        }

        if (StringUtils.isEmpty(userBO.getNickName())){
            userBO.setNickName(userBO.getLoginName());//默认昵称为登录名
        }
        User user = new User();
        BeanUtils.copyProperties(userBO, user);
        String encryptPwd = UserUtil.getUserEncryptPassword(userBO.getLoginName(), userBO.getUserPwd());
        user.setUserPwd(encryptPwd);
        try{
            // 设置默认头像
            user.setHeadImgUrl("http://reading.zealon.cn/default.jpg");
            user.setUuid(CommonUtil.getUUID());
            this.mapper.insertUser(user);
        } catch (Exception ex) {
            LOGGER.error("注册用户失败了！{}; user:{}", ex, user);
            return ResultUtil.fail().buildMessage("注册失败，服务器被吃了! ＝(#>д<)ﾉ");
        }
        return ResultUtil.success().buildMessage("注册成功！请登录吧");
    }

    @Override
    public Result<AuthVO> login(String username, String password) {
        User user = mapper.login(username);
        if (null == user) {
            return ResultUtil.notFound().buildMessage("登录失败，用户不存在！");
        }

        // 校验用户密码
        String encryptPwd = UserUtil.getUserEncryptPassword(username, password);
        if (!user.getUserPwd().equals(encryptPwd)) {
            return ResultUtil.verificationFailed().buildMessage("登录失败，密码输入错误！");
        }
        // 登录成功，返回用户信息
        AuthVO vo = new AuthVO();
        UserVO userVo = new UserVO();
        BeanUtils.copyProperties(user, userVo);
        vo.setToken(JwtUtil.buildJwt(this.getLoginExpre(), userVo));
        vo.setUser(userVo);
        return ResultUtil.success(vo);
    }
    /**
     * 获取登陆过期时间
     * @return
     */
    private Date getLoginExpre(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, EXPIRE_DAY);
        return calendar.getTime();
    }
}
