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
public class TypeCus extends Entity {
	private static final long serialVersionUID = 1L;
	
	private Long typesId;
	private Long typeCusId;
	private Long cusId;
	private Long tcOrder;
	private String typesName;
	private String typesSts;
	private Long typesPid;
	private Long typesTimes;
	private String maxOrder;
	
	public void setTypeCusId(Long typeCusId) {
		this.typeCusId = typeCusId;
	}
	
	public Long getTypeCusId() {
		return this.typeCusId;
	}
	public void setTypesId(Long typesId) {
		this.typesId = typesId;
	}
	
	public Long getTypesId() {
		return this.typesId;
	}
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	
	public Long getCusId() {
		return this.cusId;
	}
	public void setTcOrder(Long tcOrder) {
		this.tcOrder = tcOrder;
	}
	
	public Long getTcOrder() {
		return this.tcOrder;
	}

	public String getTypesName() {
		return typesName;
	}

	public void setTypesName(String typesName) {
		this.typesName = typesName;
	}

	public String getTypesSts() {
		return typesSts;
	}

	public void setTypesSts(String typesSts) {
		this.typesSts = typesSts;
	}

	public Long getTypesPid() {
		return typesPid;
	}

	public void setTypesPid(Long typesPid) {
		this.typesPid = typesPid;
	}

	public Long getTypesTimes() {
		return typesTimes;
	}

	public void setTypesTimes(Long typesTimes) {
		this.typesTimes = typesTimes;
	}

	public String getMaxOrder() {
		return maxOrder;
	}

	public void setMaxOrder(String maxOrder) {
		this.maxOrder = maxOrder;
	}
}