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
public class TypeImgsQB extends QueryBean {
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long typeImgId;
	private java.lang.String typeImgAddr;
	private java.lang.Long typeId;
	private java.lang.Long cusId;
	
	public void setTypeImgId(java.lang.Long typeImgId) {
		this.typeImgId = typeImgId;
	}
	
	public java.lang.Long getTypeImgId() {
		return this.typeImgId;
	}
	public void setTypeImgAddr(java.lang.String typeImgAddr) {
		this.typeImgAddr = typeImgAddr;
	}
	
	public java.lang.String getTypeImgAddr() {
		return this.typeImgAddr;
	}
	public void setTypeId(java.lang.Long typeId) {
		this.typeId = typeId;
	}
	
	public java.lang.Long getTypeId() {
		return this.typeId;
	}

	public java.lang.Long getCusId() {
		return cusId;
	}

	public void setCusId(java.lang.Long cusId) {
		this.cusId = cusId;
	}
}