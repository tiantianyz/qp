package com.qp.entity;

public class PagingQueryBean<T extends QueryBean> {
	
	private PagingInfo pagingInfo;
	
	private T queryBean;

	public PagingInfo getPagingInfo() {
		return this.pagingInfo;
	}

	public void setPagingInfo(PagingInfo pagingInfo) {
		this.pagingInfo = pagingInfo;
	}

	public T getQueryBean() {
		return this.queryBean;
	}

	public void setQueryBean(T queryBean) {
		this.queryBean = queryBean;
	}

}
