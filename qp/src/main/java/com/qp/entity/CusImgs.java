/*
 * Powered By Generator Util
 */
package com.qp.entity;

import com.cattsoft.baseplatform.core.entity.Entity;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public class CusImgs extends Entity {
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long cusId;
	private java.lang.String imgsAddr;
	private java.lang.String sts;
	private java.lang.Long typesId;
	private java.lang.Long cusImgId;
	
	public void setCusId(java.lang.Long cusId) {
		this.cusId = cusId;
	}
	
	public java.lang.Long getCusId() {
		return this.cusId;
	}
	public void setImgsAddr(java.lang.String imgsAddr) {
		this.imgsAddr = imgsAddr;
	}
	
	public java.lang.String getImgsAddr() {
		return this.imgsAddr;
	}
	public void setSts(java.lang.String sts) {
		this.sts = sts;
	}
	
	public java.lang.String getSts() {
		return this.sts;
	}
	public void setTypesId(java.lang.Long typesId) {
		this.typesId = typesId;
	}
	
	public java.lang.Long getTypesId() {
		return this.typesId;
	}
	public void setCusImgId(java.lang.Long cusImgId) {
		this.cusImgId = cusImgId;
	}
	
	public java.lang.Long getCusImgId() {
		return this.cusImgId;
	}
}