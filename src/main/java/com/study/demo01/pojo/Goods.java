package com.study.demo01.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "handler" })
public class Goods {
    private Integer goodsId;

    private String goodsName;

    private Integer goodsPrice;

    private String goodsImage;

    @Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsImage="
				+ goodsImage + ", goodsInventory=" + goodsInventory + ", goodsType=" + goodsType
				+ ", goodsModifiedtime=" + goodsModifiedtime + "]";
	}
	private Integer goodsInventory;

    private GoodsType goodsType;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")	
    private Date goodsModifiedtime;
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public Integer getGoodsInventory() {
		return goodsInventory;
	}
	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public Date getGoodsModifiedtime() {
		return goodsModifiedtime;
	}
	public void setGoodsModifiedtime(Date goodsModifiedtime) {
		this.goodsModifiedtime = goodsModifiedtime;
	}
}