package com.qp.bean.request;

import java.util.List;

import com.qp.entity.TypeImgs;
/**
 * 用户评论 请求实体
* @ClassName: AddCommentReqBean 
* @Description:
* @author ls
* @date 2014-11-26 上午10:01:20
 */
public class TypesReqBean extends BaseRequestBean {
private static final long serialVersionUID = 1L;
	
	private java.lang.Long typesId;
	private java.lang.String typesName;
	private java.lang.String typesOrder;
	private java.lang.String typesSts;
	private java.lang.Long typesPid;
	private Long cusId;
	private Long tcOrder;
	private List<TypeImgs> typeImgs;
	public java.lang.Long getTypesId() {
		return typesId;
	}
	public void setTypesId(java.lang.Long typesId) {
		this.typesId = typesId;
	}
	public java.lang.String getTypesName() {
		return typesName;
	}
	public void setTypesName(java.lang.String typesName) {
		this.typesName = typesName;
	}
	public java.lang.String getTypesOrder() {
		return typesOrder;
	}
	public void setTypesOrder(java.lang.String typesOrder) {
		this.typesOrder = typesOrder;
	}
	public java.lang.String getTypesSts() {
		return typesSts;
	}
	public void setTypesSts(java.lang.String typesSts) {
		this.typesSts = typesSts;
	}
	public java.lang.Long getTypesPid() {
		return typesPid;
	}
	public void setTypesPid(java.lang.Long typesPid) {
		this.typesPid = typesPid;
	}
	public Long getCusId() {
		return cusId;
	}
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	public Long getTcOrder() {
		return tcOrder;
	}
	public void setTcOrder(Long tcOrder) {
		this.tcOrder = tcOrder;
	}
	public List<TypeImgs> getTypeImgs() {
		return typeImgs;
	}
	public void setTypeImgs(List<TypeImgs> typeImgs) {
		this.typeImgs = typeImgs;
	}
}
