/*
 * Powered By Generator Util
 */
package com.qp.entity.querybean;

import com.cattsoft.baseplatform.core.entity.QueryBean;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public class LaudQB extends QueryBean {
	private static final long serialVersionUID = 1L;
	
	private java.lang.String openId;
	private java.lang.Long cusId;
	private java.lang.String remark;
	
	public void setOpenId(java.lang.String openId) {
		this.openId = openId;
	}
	
	public java.lang.String getOpenId() {
		return this.openId;
	}
	public java.lang.Long getCusId() {
		return cusId;
	}

	public void setCusId(java.lang.Long cusId) {
		this.cusId = cusId;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
}