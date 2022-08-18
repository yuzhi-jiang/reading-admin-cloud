package com.yefeng.adminaccount.dao;

import cn.zealon.readingcloud.common.pojo.account.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper extends BaseMapper<User> {
    @Select("select * from user where login_name = #{username}")
    User login(String username);
    
    @Insert("insert into user (id, uuid, user_pwd,\n" +
            "        login_name, nick_name, phone_number,\n" +
            "        head_img_url, create_time, update_time\n" +
            "        )\n" +
            "      values (#{id}, #{uuid}, #{userPwd},\n" +
            "        #{loginName}, #{nickName}, #{phoneNumber},\n" +
            "        #{headImgUrl}, now(), now()\n" +
            "        )")
    int insertUser(User user);

    @Select("select * from user where login_name = #{loginName}")
    User selectByLoginName(@Param("loginName") String loginName);
}