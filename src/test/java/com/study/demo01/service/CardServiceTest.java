package com.study.demo01.service;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.demo01.pojo.Student;
import com.study.demo01.pojo.UserInfo;

@SpringBootTest
public class CardServiceTest {
	@Autowired
	private ICardService cardService;
	@Test
	public void testSelectByUserLoginAndUserPwd() {
		UserInfo userInfo=cardService.selectByUserLoginAndUserPwd("zhangsan", "123456");
		System.out.println(userInfo);
	}
	@Test
	public void testListAllStu() {
		List<Student> list=cardService.listAllStu();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
