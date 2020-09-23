package com.study.demo01.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.demo01.pojo.College;
import com.study.demo01.service.ICardService;

@RestController
@RequestMapping("/card")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class CollegeController {
	@Autowired
	private ICardService cardService;
	@RequestMapping("/getcollegelist")
	public List<College> listAllCollege(){
		List<College> collegeList=cardService.listAllCollege();
		collegeList.stream().forEach(System.out::println);
		return collegeList;
	}
}
