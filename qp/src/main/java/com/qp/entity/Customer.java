/*
 * Powered By Generator Util
 */
package com.qp.entity;

import java.util.List;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public class Customer extends Entity {
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long cusId;
	private java.lang.String cusName;
	private java.lang.Long cusPhone;
	private java.lang.String cusPhone1;
	private java.lang.String cusPhone2;
	private java.lang.String cusRemark;
	private java.lang.String cusAddr;
	private java.lang.Long cusOrder;
	private java.util.Date cusDate;
	private java.lang.Long cusTimes;
	private String cusScope;
	private String cusSite;
	private String cusDesc;
	private String cusHeadImg;
	private List<CusImgs> imgs;
	private String openId;
	private String lop;
	
	
	public void setCusId(java.lang.Long cusId) {
		this.cusId = cusId;
	}
	
	public java.lang.Long getCusId() {
		return this.cusId;
	}
	public void setCusName(java.lang.String cusName) {
		this.cusName = cusName;
	}
	
	public java.lang.String getCusName() {
		return this.cusName;
	}
	public void setCusPhone(java.lang.Long cusPhone) {
		this.cusPhone = cusPhone;
	}
	
	public java.lang.Long getCusPhone() {
		return this.cusPhone;
	}
	public void setCusPhone1(java.lang.String cusPhone1) {
		this.cusPhone1 = cusPhone1;
	}
	
	public java.lang.String getCusPhone1() {
		return this.cusPhone1;
	}
	public void setCusPhone2(java.lang.String cusPhone2) {
		this.cusPhone2 = cusPhone2;
	}
	
	public java.lang.String getCusPhone2() {
		return this.cusPhone2;
	}
	public void setCusRemark(java.lang.String cusRemark) {
		this.cusRemark = cusRemark;
	}
	
	public java.lang.String getCusRemark() {
		return this.cusRemark;
	}
	public void setCusAddr(java.lang.String cusAddr) {
		this.cusAddr = cusAddr;
	}
	
	public java.lang.String getCusAddr() {
		return this.cusAddr;
	}
	public void setCusOrder(java.lang.Long cusOrder) {
		this.cusOrder = cusOrder;
	}
	
	public java.lang.Long getCusOrder() {
		return this.cusOrder;
	}
	public void setCusDate(java.util.Date cusDate) {
		this.cusDate = cusDate;
	}
	
	public java.util.Date getCusDate() {
		return this.cusDate;
	}
	public void setCusTimes(java.lang.Long cusTimes) {
		this.cusTimes = cusTimes;
	}
	
	public java.lang.Long getCusTimes() {
		return this.cusTimes;
	}

	public String getCusScope() {
		return cusScope;
	}

	public void setCusScope(String cusScope) {
		this.cusScope = cusScope;
	}

	public String getCusSite() {
		return cusSite;
	}

	public void setCusSite(String cusSite) {
		this.cusSite = cusSite;
	}
	
	public String getCusDesc() {
		return cusDesc;
	}

	public void setCusDesc(String cusDesc) {
		this.cusDesc = cusDesc;
	}

	public List<CusImgs> getImgs() {
		return imgs;
	}

	public void setImgs(List<CusImgs> imgs) {
		this.imgs = imgs;
	}

	public String getCusHeadImg() {
		return cusHeadImg;
	}

	public void setCusHeadImg(String cusHeadImg) {
		this.cusHeadImg = cusHeadImg;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
}