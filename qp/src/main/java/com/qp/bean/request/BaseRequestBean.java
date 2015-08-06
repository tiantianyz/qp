package com.qp.bean.request;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseRequestBean implements Serializable{

    /**
     * 参数自动填充完之后调用
     * 在这里做参数变换，以及装饰器无法自动获取逻辑，如果十分需要，请覆盖这个方法
     */
    public void afterSetBean(HttpServletRequest request){
    
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomStringStyle());
    }
    
	/**
	 * 分页信息
	 */
	private PageInfoReqBean pageInfo;

	public PageInfoReqBean getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfoReqBean pageInfo) {
		this.pageInfo = pageInfo;
	}

}
