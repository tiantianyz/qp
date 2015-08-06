package com.qp.bean.request;
/**
 * 分页请求实体
* @ClassName: PageInfoReqBean 
* @Description:
* @author ls
* @date 2014-11-24 下午3:39:56
 */
public class PageInfoReqBean {
	/**
	 * 当前页
	 */
	private Integer currentPage;
	/**
	 * 每页条数
	 */
	private Integer pageNum;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
}
