/*
 * Powered By Generator Util
 */
package com.qp.entity.querybean;

import com.qp.entity.QueryBean;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public class CustomerQB extends QueryBean {
	private static final long serialVersionUID = 1L;
	
	private Long cusId;
	private String cusName;
	private Long cusPhone;
	private String cusPhone1;
	private String cusPhone2;
	private String cusRemark;
	private String cusHeadImg;
	private String cusDesc;
	private String cusAddr;
	private Long cusOrder;
	private java.util.Date cusDate;
	private Long cusTimes;
	private Long typesId;
	private String cusIds;
	private String cusNamel;
	private String openId;
	
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	
	public Long getCusId() {
		return this.cusId;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	
	public String getCusName() {
		return this.cusName;
	}
	public void setCusPhone(Long cusPhone) {
		this.cusPhone = cusPhone;
	}
	
	public Long getCusPhone() {
		return this.cusPhone;
	}
	public void setCusPhone1(String cusPhone1) {
		this.cusPhone1 = cusPhone1;
	}
	
	public String getCusPhone1() {
		return this.cusPhone1;
	}
	public void setCusPhone2(String cusPhone2) {
		this.cusPhone2 = cusPhone2;
	}
	
	public String getCusPhone2() {
		return this.cusPhone2;
	}
	public void setCusRemark(String cusRemark) {
		this.cusRemark = cusRemark;
	}
	
	public String getCusRemark() {
		return this.cusRemark;
	}
	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}
	
	public String getCusAddr() {
		return this.cusAddr;
	}
	public void setCusOrder(Long cusOrder) {
		this.cusOrder = cusOrder;
	}
	
	public Long getCusOrder() {
		return this.cusOrder;
	}
	public void setCusDate(java.util.Date cusDate) {
		this.cusDate = cusDate;
	}
	
	public java.util.Date getCusDate() {
		return this.cusDate;
	}
	public void setCusTimes(Long cusTimes) {
		this.cusTimes = cusTimes;
	}
	
	public Long getCusTimes() {
		return this.cusTimes;
	}

	public Long getTypesId() {
		return typesId;
	}

	public void setTypesId(Long typesId) {
		this.typesId = typesId;
	}

	public String getCusIds() {
		return cusIds;
	}

	public void setCusIds(String cusIds) {
		this.cusIds = cusIds;
	}

	public String getCusHeadImg() {
		return cusHeadImg;
	}

	public void setCusHeadImg(String cusHeadImg) {
		this.cusHeadImg = cusHeadImg;
	}

	public String getCusDesc() {
		return cusDesc;
	}
	
	public void setCusDesc(String cusDesc) {
		this.cusDesc = cusDesc;
	}

	public String getCusNamel() {
		return cusNamel;
	}

	public void setCusNamel(String cusNamel) {
		this.cusNamel = cusNamel;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}