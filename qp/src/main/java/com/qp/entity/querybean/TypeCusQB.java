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
public class TypeCusQB extends QueryBean {
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long typeCusId;
	private java.lang.Long typesId;
	private java.lang.Long cusId;
	private java.lang.Long tcOrder;
	private String openId;
	
	public void setTypeCusId(java.lang.Long typeCusId) {
		this.typeCusId = typeCusId;
	}
	
	public java.lang.Long getTypeCusId() {
		return this.typeCusId;
	}
	public void setTypesId(java.lang.Long typesId) {
		this.typesId = typesId;
	}
	
	public java.lang.Long getTypesId() {
		return this.typesId;
	}
	public void setCusId(java.lang.Long cusId) {
		this.cusId = cusId;
	}
	
	public java.lang.Long getCusId() {
		return this.cusId;
	}
	public void setTcOrder(java.lang.Long tcOrder) {
		this.tcOrder = tcOrder;
	}
	
	public java.lang.Long getTcOrder() {
		return this.tcOrder;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}