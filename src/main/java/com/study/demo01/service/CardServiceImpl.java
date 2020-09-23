package com.study.demo01.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.demo01.dao.CollegeMapper;
import com.study.demo01.dao.GoodsMapper;
import com.study.demo01.dao.GoodsTypeMapper;
import com.study.demo01.dao.StudentMapper;
import com.study.demo01.dao.UserInfoMapper;
import com.study.demo01.pojo.College;
import com.study.demo01.pojo.Goods;
import com.study.demo01.pojo.GoodsType;
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
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsTypeMapper goodsTypeMapper;
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
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean deleteStudentById(Integer stuId) {
		return studentMapper.deleteByPrimaryKey(stuId)>0;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean deleteSelectedStudentByIds(Integer[] stuIds) {
		int count=0;
		Boolean rt=false;
		for (int i = 0; i < stuIds.length; i++) {
			if(studentMapper.deleteByPrimaryKey(stuIds[i])>0) {
				count++;
			}
		}
		if (count==stuIds.length) {
			System.out.println(count);
			rt=true;
		}
		return rt;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean addStudentSelective(Student student) {
		return studentMapper.insertSelective(student)>0;
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Student> listStuByNameOrNo(String condition) {
		return studentMapper.listStuByNameOrNo("%"+condition+"%");
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Goods> listAllGoods() {
		return goodsMapper.listAllGoods();
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Goods queryGoodsById(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean updateGoods(Goods goods) {
		if (goods.getGoodsModifiedtime().equals(goodsMapper.selectByPrimaryKey(goods.getGoodsId()).getGoodsModifiedtime())) {
			goods.setGoodsModifiedtime(new Date());
			return goodsMapper.updateByPrimaryKey(goods)>0;
		}
		return false;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean addGoodsSelective(Goods goods) {
		goods.setGoodsModifiedtime(new Date());
		return goodsMapper.insertSelective(goods)>0;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean deleteGoodsById(Integer goodsId) {
		return goodsMapper.deleteByPrimaryKey(goodsId)>0;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean deleteGoodsSelected(Integer[] ids) {
		int count=0;
		Boolean rt=false;
		for (int i = 0; i < ids.length; i++) {
			if(goodsMapper.deleteByPrimaryKey(ids[i])>0) {
				count++;
			}
		}
		if (count==ids.length) {
			System.out.println(count);
			rt=true;
		}
		return rt;
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Goods> listGoodsByNameOrPrice(String condition) {
		
		return goodsMapper.listGoodsByNameOrPrice("%"+condition+"%");
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<GoodsType> listAllGoodsTypes() {
		return goodsTypeMapper.listAllGoodsTypes();
	}
}
