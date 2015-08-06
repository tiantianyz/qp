/*
 * Powered By Generator Util
 */
package com.qp.bean.response;

import java.util.List;

import com.qp.entity.AdminDivision;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public class AdRspBean extends BaseResponseBean {
	private static final long serialVersionUID = 1L;
	
	private Long divisionId;
	private Long divisionPid;
	private String divisionCode;
	private String divisionName;
	private Integer divisionLevel;
	private String sts;
	private java.util.Date stsTime;
	
	private List<AdminDivision> ads;
	
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}
	
	public Long getDivisionId() {
		return this.divisionId;
	}
	public void setDivisionPid(Long divisionPid) {
		this.divisionPid = divisionPid;
	}
	
	public Long getDivisionPid() {
		return this.divisionPid;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	public String getDivisionCode() {
		return this.divisionCode;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	
	public String getDivisionName() {
		return this.divisionName;
	}
	public void setDivisionLevel(Integer divisionLevel) {
		this.divisionLevel = divisionLevel;
	}
	
	public Integer getDivisionLevel() {
		return this.divisionLevel;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	public String getSts() {
		return this.sts;
	}
	public void setStsTime(java.util.Date stsTime) {
		this.stsTime = stsTime;
	}
	
	public java.util.Date getStsTime() {
		return this.stsTime;
	}

	public List<AdminDivision> getAds() {
		return ads;
	}

	public void setAds(List<AdminDivision> ads) {
		this.ads = ads;
	}
}