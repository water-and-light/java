package com.study.demo01.dao;

import java.util.List;

import com.study.demo01.pojo.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    List<Goods> listAllGoods();
    
    List<Goods> listGoodsByNameOrPrice(String condition);
}