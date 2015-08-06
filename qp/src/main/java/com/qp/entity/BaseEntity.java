package com.qp.entity;

import com.qp.basic.util.SysConstUtil;

public class BaseEntity extends com.cattsoft.baseplatform.core.entity.Entity{

	private String baseUrl = SysConstUtil.HTTP_FILE_SYS_BASE_URL;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
}
