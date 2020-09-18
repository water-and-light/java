package com.study.demo01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.demo01.dao.CollegeMapper;
import com.study.demo01.dao.StudentMapper;
import com.study.demo01.dao.UserInfoMapper;
import com.study.demo01.pojo.College;
import com.study.demo01.pojo.Student;
import com.study.demo01.pojo.UserInfo;
import com.study.demo01.util.MD5;
@Service
public class CardServiceImpl implements ICardService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CollegeMapper collegeMapper;
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public UserInfo selectByUserLoginAndUserPwd(String userLogin, String userPasswd) {
		return userInfoMapper.selectByUserLoginAndUserPwd(userLogin, MD5.enctypeMD5("haha"+userPasswd));
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Student> listAllStu() {
		return studentMapper.listAllStu();
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Student queryStudentByStuId(Integer stuId) {
		return studentMapper.selectByPrimaryKey(stuId);
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<College> listAllCollege() {
		return collegeMapper.listAllCollege();
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean updateStudentSelective(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKeySelective(student)>0;
	}
}
