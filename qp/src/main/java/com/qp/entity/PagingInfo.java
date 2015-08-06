package com.qp.entity;

public class PagingInfo {


	// 每页行数
	private int pageRows;

	// 当前页码
	private int pageNum;

	// 偏移量，0-based
	private int offset;

	// 分页查询起始/结束编号，1-based
	private int startIdx, endIdx;

	// 查询结果的总条数
	private int totalRows;

	// 查询结果的总页数
	private int totalPages;

	public int getPageRows() {
		return pageRows;
	}

	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getOffset() {
		offset = pageRows * (pageNum - 1);
		return offset;
	}

	public int getStartIdx() {
		if (pageRows != 0 && pageNum != 0)
			startIdx = pageRows * (pageNum - 1);
		return startIdx;
	}

	public int getEndIdx() {
		if (pageRows != 0)
			endIdx = startIdx + pageRows - 1;
		return endIdx;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		totalPages = (totalRows + pageRows - 1) / pageRows;
		return totalPages;
	}

	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}

	public void setEndIdx(int endIdx) {
		this.endIdx = endIdx;
	}
}
