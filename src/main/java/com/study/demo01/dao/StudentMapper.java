package com.study.demo01.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.demo01.pojo.Student;

public interface StudentMapper {
	List<Student> listAllStu();
	
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> listStuByNameOrNo(String condition);
    
    Student verifyStudentByLoginAndPasswd(@Param("stuLogin")String stuLogin,@Param("stuPasswd")String stuPasswd);
}