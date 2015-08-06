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
public class AdminDivision extends Entity {
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long divisionId;
	private java.lang.Long divisionPid;
	private java.lang.String divisionCode;
	private java.lang.String divisionName;
	private java.lang.Integer divisionLevel;
	private java.lang.String sts;
	private java.util.Date stsTime;
	
	public void setDivisionId(java.lang.Long divisionId) {
		this.divisionId = divisionId;
	}
	
	public java.lang.Long getDivisionId() {
		return this.divisionId;
	}
	public void setDivisionPid(java.lang.Long divisionPid) {
		this.divisionPid = divisionPid;
	}
	
	public java.lang.Long getDivisionPid() {
		return this.divisionPid;
	}
	public void setDivisionCode(java.lang.String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	public java.lang.String getDivisionCode() {
		return this.divisionCode;
	}
	public void setDivisionName(java.lang.String divisionName) {
		this.divisionName = divisionName;
	}
	
	public java.lang.String getDivisionName() {
		return this.divisionName;
	}
	public void setDivisionLevel(java.lang.Integer divisionLevel) {
		this.divisionLevel = divisionLevel;
	}
	
	public java.lang.Integer getDivisionLevel() {
		return this.divisionLevel;
	}
	public void setSts(java.lang.String sts) {
		this.sts = sts;
	}
	
	public java.lang.String getSts() {
		return this.sts;
	}
	public void setStsTime(java.util.Date stsTime) {
		this.stsTime = stsTime;
	}
	
	public java.util.Date getStsTime() {
		return this.stsTime;
	}
	
}