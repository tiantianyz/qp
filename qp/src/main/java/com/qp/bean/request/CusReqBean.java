package com.qp.bean.request;

import java.util.List;

import com.qp.entity.CusImgs;
/**
 * 用户评论 请求实体
* @ClassName: AddCommentReqBean 
* @Description:
* @author ls
* @date 2014-11-26 上午10:01:20
 */
public class CusReqBean extends BaseRequestBean {
	private static final long serialVersionUID = 1L;
	private Long cusId;
	private String cusName;
	private Long cusPhone;
	private String cusPhone1;
	private String cusPhone2;
	private String cusRemark;
	private String cusAddr;
	private Long cusOrder;
	private java.util.Date cusDate;
	private Long cusTimes;
	private Long typesId;
	private String cusSite;
	private String cusScope;
	private String cusDesc;
	private String cusHeadImg;
	private String openId;
	
	private List<CusImgs> cusImgs;
	
	public Long getCusId() {
		return cusId;
	}
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public Long getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(Long cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getCusPhone1() {
		return cusPhone1;
	}
	public void setCusPhone1(String cusPhone1) {
		this.cusPhone1 = cusPhone1;
	}
	public String getCusPhone2() {
		return cusPhone2;
	}
	public void setCusPhone2(String cusPhone2) {
		this.cusPhone2 = cusPhone2;
	}
	public String getCusRemark() {
		return cusRemark;
	}
	public Long getTypesId() {
		return typesId;
	}
	public void setTypesId(Long typesId) {
		this.typesId = typesId;
	}
	public void setCusRemark(String cusRemark) {
		this.cusRemark = cusRemark;
	}
	public String getCusAddr() {
		return cusAddr;
	}
	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}
	public Long getCusOrder() {
		return cusOrder;
	}
	public void setCusOrder(Long cusOrder) {
		this.cusOrder = cusOrder;
	}
	public java.util.Date getCusDate() {
		return cusDate;
	}
	public void setCusDate(java.util.Date cusDate) {
		this.cusDate = cusDate;
	}
	public Long getCusTimes() {
		return cusTimes;
	}
	public void setCusTimes(Long cusTimes) {
		this.cusTimes = cusTimes;
	}
	public String getCusSite() {
		return cusSite;
	}
	public void setCusSite(String cusSite) {
		this.cusSite = cusSite;
	}
	public String getCusScope() {
		return cusScope;
	}
	public void setCusScope(String cusScope) {
		this.cusScope = cusScope;
	}
	public String getCusDesc() {
		return cusDesc;
	}
	public void setCusDesc(String cusDesc) {
		this.cusDesc = cusDesc;
	}
	public String getCusHeadImg() {
		return cusHeadImg;
	}
	public void setCusHeadImg(String cusHeadImg) {
		this.cusHeadImg = cusHeadImg;
	}
	public List<CusImgs> getCusImgs() {
		return cusImgs;
	}
	public void setCusImgs(List<CusImgs> cusImgs) {
		this.cusImgs = cusImgs;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
