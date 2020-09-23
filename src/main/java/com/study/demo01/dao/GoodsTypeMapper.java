package com.study.demo01.dao;

import java.util.List;

import com.study.demo01.pojo.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
    
    List<GoodsType> listAllGoodsTypes();
}