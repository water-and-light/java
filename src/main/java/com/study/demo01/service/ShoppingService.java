package com.study.demo01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.demo01.dao.GoodsMapper;
import com.study.demo01.dao.ShoppingCartMapper;
import com.study.demo01.dao.StudentMapper;
import com.study.demo01.pojo.Goods;
import com.study.demo01.pojo.ShoppingCart;
import com.study.demo01.pojo.Student;
import com.study.demo01.util.MD5;
@Service
public class ShoppingService implements IShoppingService{
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<Goods> listAllGoods() {
		return goodsMapper.listAllGoods();
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Goods queryGoodsById(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public Student verifyStudentByLoginAndPasswd(String stuLogin, String stuPasswd) {
		return studentMapper.verifyStudentByLoginAndPasswd(stuLogin, MD5.enctypeMD5("haha"+stuPasswd));
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean addGoodsToShopingCart(ShoppingCart shoppingCart) {
		return shoppingCartMapper.insert(shoppingCart)>0;
	}
	@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT,readOnly = true)
	public List<ShoppingCart> listGoodsListByStuId(Integer stuId) {
		return shoppingCartMapper.listGoodsListByStuId(stuId);
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean deleteShoppingCartByCartId(int cartId) {
		return shoppingCartMapper.deleteByPrimaryKey(cartId)>0;
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
	public Boolean deleteShoppingCartByCartIds(Integer[] ids) {
		int count=0;
		Boolean rt=false;
		for (int i = 0; i < ids.length; i++) {
			if(shoppingCartMapper.deleteByPrimaryKey(ids[i])>0) {
				count++;
			}
		}
		if (count==ids.length) {
			System.out.println(count);
			rt=true;
		}
		return rt;
	}
}
