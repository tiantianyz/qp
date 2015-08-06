/*
 * Powered By Generator Util
 */
package com.qp.entity;

/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public class TypeImgs extends Entity {
	private static final long serialVersionUID = 1L;
	
	private Long typeImgId;
	private String typeImgAddr;
	private Long typeId;
	private Long cusId;
	private Long phone;
	private String cusName;
	
	public void setTypeImgId(Long typeImgId) {
		this.typeImgId = typeImgId;
	}
	
	public Long getTypeImgId() {
		return this.typeImgId;
	}
	public void setTypeImgAddr(String typeImgAddr) {
		this.typeImgAddr = typeImgAddr;
	}
	
	public String getTypeImgAddr() {
		return this.typeImgAddr;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	public Long getTypeId() {
		return this.typeId;
	}

	public Long getCusId() {
		return cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
}