package com.qp.bean.response;


/**
 * Description:
 *
 * Author: Ding Chengyun
 * CreateDate:2014-12-17
 * Version：V0.1
 */
public class ImageUploadRspBean {
	
	private String messageCode = "20000"; // 默认返回成功 
	private String imageUrl;
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
}
