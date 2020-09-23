package com.study.demo01.web;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.demo01.pojo.Student;
import com.study.demo01.pojo.UserInfo;
import com.study.demo01.service.ICardService;
// @RestController=@controller+@responsebody
// @CrossOrigin 允许跨域访问;设置参数允许携带cookie以解决跨域过程中session变换问题
@RestController 
@RequestMapping("/card")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class StuController {
	@Autowired
	private ICardService cardService;
	@RequestMapping(path="/login")
	public Boolean verifyLogin(@RequestBody UserInfo userInfo,HttpSession session) {
		Boolean rt=false;
		UserInfo user=cardService.selectByUserLoginAndUserPwd(userInfo.getUserLogin(),userInfo.getUserPasswd());
		if (user != null) {
			rt=true;
			session.setAttribute("user", user);
		}
		return rt;
	}
	@RequestMapping(path="/getusername")
	public String getUserName(HttpSession session) {
		UserInfo user=(UserInfo)session.getAttribute("user");
		if (user != null) {
			return user.getUserName();
		}
		return null;
	}
	@RequestMapping(path="/getstulist")
	public List<Student> getStuList() {
		List<Student> stuList=cardService.listAllStu();
		return stuList;
	}
	@RequestMapping(path="/querystu")
	public Student querystu(Integer stuId) {
		Student student=cardService.queryStudentByStuId(stuId);
		return student;
	}
	@RequestMapping("/savestu")
	public Boolean saveStudent(@RequestBody Student student) {
		if(student.getStuId()==null) {
			return cardService.addStudentSelective(student);
		} else {
			return cardService.updateStudentSelective(student);
		}
		
	}
	@RequestMapping("/deletestu")
	public Boolean deleteStudent(Integer stuId) {
		return cardService.deleteStudentById(stuId);
	}
	@RequestMapping("/deletestuselected")
	public Boolean deleteSelectedStudent(Integer[] stuIds) {
		Arrays.stream(stuIds).forEach(System.out::println);
		return cardService.deleteSelectedStudentByIds(stuIds);
	}
	@RequestMapping("/listStuByNameOrNo")
	public List<Student> listStuByNameOrNo(String condition){
		cardService.listStuByNameOrNo(condition).stream().forEach(System.out::println);
		return cardService.listStuByNameOrNo(condition);
	}
	
}
