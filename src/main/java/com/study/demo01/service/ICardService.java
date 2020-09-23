package com.study.demo01.service;

import java.util.List;

import com.study.demo01.pojo.College;
import com.study.demo01.pojo.Goods;
import com.study.demo01.pojo.GoodsType;
import com.study.demo01.pojo.Student;
import com.study.demo01.pojo.UserInfo;

public interface ICardService {
	UserInfo selectByUserLoginAndUserPwd(String userLogin,String userPasswd);
	List<Student> listAllStu();
	Student queryStudentByStuId(Integer stuId);
	List<College> listAllCollege();
	Boolean updateStudentSelective(Student student);
	Boolean deleteStudentById(Integer stuId);
	Boolean deleteSelectedStudentByIds(Integer[] stuIds);
	Boolean addStudentSelective(Student student);
	List<Student> listStuByNameOrNo(String condition);
	List<Goods> listAllGoods();
	Goods queryGoodsById(Integer goodsId);
	Boolean updateGoods(Goods goods);
	Boolean addGoodsSelective(Goods goods);
	Boolean deleteGoodsById(Integer goodsId);
	Boolean deleteGoodsSelected(Integer[] ids);
	List<Goods> listGoodsByNameOrPrice(String condition);
	List<GoodsType> listAllGoodsTypes();
}
