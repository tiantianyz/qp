package com.qp.bean.response;

import java.util.List;

import com.qp.entity.TypeImgs;
import com.qp.entity.Types;
import com.qp.entity.TypesC;

/**
 * 返回的区域信息
 * 
 * @ClassName: AreaRspBean
 * @Description:
 * @author ls
 * @date 2014-11-22 下午4:40:50
 */
public class TypesRspBean extends BaseResponseBean {

	private static final long serialVersionUID = 1L;
	
	private List<TypesC> data;
	
	private List<TypeImgs> typeImgs;
	
	private List<Types> oneData;
	
	private Long typeId;
	private String typeName;

	public List<TypesC> getData() {
		return data;
	}

	public void setData(List<TypesC> data) {
		this.data = data;
	}

	public List<TypeImgs> getTypeImgs() {
		return typeImgs;
	}

	public void setTypeImgs(List<TypeImgs> typeImgs) {
		this.typeImgs = typeImgs;
	}

	public List<Types> getOneData() {
		return oneData;
	}

	public void setOneData(List<Types> oneData) {
		this.oneData = oneData;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
