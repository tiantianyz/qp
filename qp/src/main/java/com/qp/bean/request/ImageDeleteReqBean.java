package com.qp.bean.request;

/**
 * Description:
 *
 * Author: Ding Chengyun
 * CreateDate:2014-12-18
 * Version：V0.1
 */
public class ImageDeleteReqBean {

	private int type;
	private int subType;
	private Long imageId;
	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}


	public void setSubType(Byte subType) {
		this.subType = subType;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}
	
	
}
