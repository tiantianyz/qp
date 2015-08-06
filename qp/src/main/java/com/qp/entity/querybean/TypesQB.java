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
public class TypesQB extends QueryBean {
	private static final long serialVersionUID = 1L;
	
	private Long typesId;
	private String typesName;
	private String typesOrder;
	private String typesSts;
	private Long typesPid;
	
	public void setTypesId(Long typesId) {
		this.typesId = typesId;
	}
	
	public Long getTypesId() {
		return this.typesId;
	}
	public void setTypesName(String typesName) {
		this.typesName = typesName;
	}
	
	public String getTypesName() {
		return this.typesName;
	}
	public void setTypesOrder(String typesOrder) {
		this.typesOrder = typesOrder;
	}
	
	public String getTypesOrder() {
		return this.typesOrder;
	}
	public void setTypesSts(String typesSts) {
		this.typesSts = typesSts;
	}
	
	public String getTypesSts() {
		return this.typesSts;
	}
	public void setTypesPid(Long typesPid) {
		this.typesPid = typesPid;
	}
	
	public Long getTypesPid() {
		return this.typesPid;
	}
}