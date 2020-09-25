package com.study.demo01.service;

import java.util.List;

import com.study.demo01.pojo.Goods;
import com.study.demo01.pojo.ShoppingCart;
import com.study.demo01.pojo.Student;

public interface IShoppingService {
	List<Goods> listAllGoods();
	Goods queryGoodsById(Integer goodsId);
	Student verifyStudentByLoginAndPasswd(String stuLogin,String stuPasswd);
	Boolean addGoodsToShopingCart (ShoppingCart shoppingCart);
	List<ShoppingCart> listGoodsListByStuId(Integer stuId);
	Boolean deleteShoppingCartByCartId(int cartId);
	Boolean deleteShoppingCartByCartIds(Integer[] ids);
}
