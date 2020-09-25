package com.study.demo01.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"handler"})
public class ShoppingCart {

	private Integer cartId;

    private Integer studentId;

    private Goods goods;

    private Integer goodsNum;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", studentId=" + studentId + ", goods=" + goods + ", goodsNum="
				+ goodsNum + "]";
	}

   
}