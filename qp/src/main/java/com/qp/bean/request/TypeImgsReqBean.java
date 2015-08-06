package com.qp.bean.request;

/**
 * 用户评论 请求实体
* @ClassName: AddCommentReqBean 
* @Description:
* @author ls
* @date 2014-11-26 上午10:01:20
 */
public class TypeImgsReqBean extends BaseRequestBean {
private static final long serialVersionUID = 1L;
	
	private Long typeImgId;
	private String typeImgAddr;
	private Long typeId;
	private Long cusId;
	private String cusName;
	public Long getTypeImgId() {
		return typeImgId;
	}
	public void setTypeImgId(Long typeImgId) {
		this.typeImgId = typeImgId;
	}
	public String getTypeImgAddr() {
		return typeImgAddr;
	}
	public void setTypeImgAddr(String typeImgAddr) {
		this.typeImgAddr = typeImgAddr;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
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
	
}
