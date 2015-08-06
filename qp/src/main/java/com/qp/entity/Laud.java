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
public class Laud extends Entity {
	private static final long serialVersionUID = 1L;
	
	private java.lang.String openId;
	private Long cusId;
	private java.lang.String remark;
	
	public void setOpenId(java.lang.String openId) {
		this.openId = openId;
	}
	
	public java.lang.String getOpenId() {
		return this.openId;
	}
	
	public Long getCusId() {
		return cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
}