/*
 * Powered By Generator Util
 */
package com.qp.bean.response;

import java.util.List;

import com.qp.entity.Garages;
import com.qp.entity.PagingInfo;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public class GaragesRspBean extends BaseResponseBean{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long garageId;
	private java.lang.String garageName;
	private java.lang.String garagePhone;
	private java.lang.Long areaId;
	private java.lang.String garageImg;
	private java.util.Date createDate;
	private String garageRemark;
	private int gtype;
	
	private PagingInfo pageInfo;
	
	private List<Garages> garage;
	
	public void setGarageId(java.lang.Long garageId) {
		this.garageId = garageId;
	}
	
	public java.lang.Long getGarageId() {
		return this.garageId;
	}
	public void setGarageName(java.lang.String garageName) {
		this.garageName = garageName;
	}
	
	public java.lang.String getGarageName() {
		return this.garageName;
	}
	public void setGaragePhone(java.lang.String garagePhone) {
		this.garagePhone = garagePhone;
	}
	
	public java.lang.String getGaragePhone() {
		return this.garagePhone;
	}
	public void setAreaId(java.lang.Long areaId) {
		this.areaId = areaId;
	}
	
	public java.lang.Long getAreaId() {
		return this.areaId;
	}
	public void setGarageImg(java.lang.String garageImg) {
		this.garageImg = garageImg;
	}
	
	public java.lang.String getGarageImg() {
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

	public PagingInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PagingInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<Garages> getGarage() {
		return garage;
	}

	public void setGarage(List<Garages> garage) {
		this.garage = garage;
	}

	public int getGtype() {
		return gtype;
	}

	public void setGtype(int gtype) {
		this.gtype = gtype;
	}

}