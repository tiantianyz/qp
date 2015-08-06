package com.qp.entity;

import java.util.List;

public class PagingResultBean<T extends List<? extends Entity>> {
	
	private PagingInfo pagingInfo;
	
	private T resultList;

	public PagingInfo getPagingInfo() {
		return this.pagingInfo;
	}

	public void setPagingInfo(PagingInfo pagingInfo) {
		this.pagingInfo = pagingInfo;
	}

	public T getResultList() {
		return this.resultList;
	}

	public void setResultList(T resultList) {
		this.resultList = resultList;
	}
	
	
}
