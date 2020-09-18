package com.study.demo01.dao;


import java.util.List;

import com.study.demo01.pojo.College;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeId);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
    
    List<College> listAllCollege();
}