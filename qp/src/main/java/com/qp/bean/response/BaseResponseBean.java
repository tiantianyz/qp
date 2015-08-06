package com.qp.bean.response;

import java.io.Serializable;

public class BaseResponseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7040356966584492207L;
	private String messageCode = "20000"; // 默认返回成功 
	private String description = "正常";
	
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BaseResponseBean [messageCode=" + messageCode
				+ ", description=" + description + "]";
	}
}
