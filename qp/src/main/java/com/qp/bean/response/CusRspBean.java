package com.qp.bean.response;

import java.util.List;

import com.qp.entity.Customer;
import com.qp.entity.PagingInfo;
import com.qp.entity.TypeImgs;

/**
 * 返回的区域信息
 * 
 * @ClassName: AreaRspBean
 * @Description:
 * @author ls
 * @date 2014-11-22 下午4:40:50
 */
public class CusRspBean extends BaseResponseBean {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private String value;
	private List<Customer> data;
	private List<TypeImgs> typeImgs;
	private PagingInfo pageInfo;
	private Customer customer;
	private Long phone;
	private int isCol;
	private int isLaud;
	private String uuid;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Customer> getData() {
		return data;
	}
	public void setData(List<Customer> data) {
		this.data = data;
	}
	public PagingInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PagingInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public List<TypeImgs> getTypeImgs() {
		return typeImgs;
	}
	public void setTypeImgs(List<TypeImgs> typeImgs) {
		this.typeImgs = typeImgs;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public int getIsCol() {
		return isCol;
	}
	public void setIsCol(int isCol) {
		this.isCol = isCol;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getIsLaud() {
		return isLaud;
	}
	public void setIsLaud(int isLaud) {
		this.isLaud = isLaud;
	}
}
