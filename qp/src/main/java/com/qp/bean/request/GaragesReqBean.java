/*
 * Powered By Generator Util
 */
package com.qp.bean.request;

/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public class GaragesReqBean extends BaseRequestBean {
	private static final long serialVersionUID = 1L;
	
	private Long garageId;
	private String garageName;
	private String garagePhone;
	private Long areaId;
	private String garageImg;
	private java.util.Date createDate;
	private String garageRemark;
	private int gtype;
	
	public void setGarageId(Long garageId) {
		this.garageId = garageId;
	}
	
	public Long getGarageId() {
		return this.garageId;
	}
	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}
	
	public String getGarageName() {
		return this.garageName;
	}
	public void setGaragePhone(String garagePhone) {
		this.garagePhone = garagePhone;
	}
	
	public String getGaragePhone() {
		return this.garagePhone;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	
	public Long getAreaId() {
		return this.areaId;
	}
	public void setGarageImg(String garageImg) {
		this.garageImg = garageImg;
	}
	
	public String getGarageImg() {
		return this.garageImg;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	public String getGarageRemark() {
		return garageRemark;
	}

	public void setGarageRemark(String garageRemark) {
		this.garageRemark = garageRemark;
	}

	public int getGtype() {
		return gtype;
	}

	public void setGtype(int gtype) {
		this.gtype = gtype;
	}
}