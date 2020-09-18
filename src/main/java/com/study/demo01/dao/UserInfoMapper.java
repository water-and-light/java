package com.study.demo01.dao;

import org.apache.ibatis.annotations.Param;

import com.study.demo01.pojo.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    UserInfo selectByUserLoginAndUserPwd(@Param("userLogin")String userLogin,@Param("userPasswd")String userPasswd);
}