package com.study.demo01.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.demo01.pojo.UserInfo;
import com.study.demo01.util.MD5;

@SpringBootTest
public class DaoTest {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Test
	public void testSelectByUserLoginAndUserPwd () {
		UserInfo userInfo=userInfoMapper.selectByUserLoginAndUserPwd("zhangsan", MD5.enctypeMD5("haha123456"));
		System.out.println(userInfo);
	}
}
