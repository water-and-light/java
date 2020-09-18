package com.study.demo01.service;

import java.util.List;

import com.study.demo01.pojo.College;
import com.study.demo01.pojo.Student;
import com.study.demo01.pojo.UserInfo;

public interface ICardService {
	UserInfo selectByUserLoginAndUserPwd(String userLogin,String userPasswd);
	List<Student> listAllStu();
	Student queryStudentByStuId(Integer stuId);
	List<College> listAllCollege();
	Boolean updateStudentSelective(Student student);
}
