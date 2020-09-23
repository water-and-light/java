package com.study.demo01.dao;

import com.study.demo01.pojo.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}