/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.cattsoft.baseplatform.core.entity.PagingResultBean;
import com.qp.entity.CusImgs;
import com.qp.entity.querybean.CusImgsQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface CusImgsService {
	/**
	 * 增加cus_imgs信息
	 * 
	 * @param cusImgs cus_imgs信息
	 *
	 * @return cus_imgs标识
	 */
	Long createCusImgs(CusImgs cusImgs);

	/**
	 * 修改cus_imgs信息
	 * 
	 * @param cusImgs cus_imgs信息
	 */
	void updateCusImgs(CusImgs cusImgs);

	/**
	 * 删除cus_imgs信息
	 * 
	 * @param cusImgId cus_imgs标识
	 */
	void removeCusImgs(Long cusImgId);

	/**
	 * 获取cus_imgs信息
	 * 
	 * @param cusImgId cus_imgs标识
	 * @return cus_imgs信息
	 */
	CusImgs getCusImgs(Long cusImgId);

	/**
	 * 获取所有cus_imgs
	 * 
	 * @return 所有cus_imgs信息的列表
	 */
	List<CusImgs> getAllCusImgss();
	
	/**
	 * 根据查询对象查询cus_imgs结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  cus_imgs记录列表
	 */
	List<CusImgs> getCusImgss(CusImgsQB queryBean);

	/**
	 * 分页获取cus_imgs列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页cus_imgs列表
	 */
	PagingResultBean<List<CusImgs>> getAllCusImgssPaging(PagingQueryBean<CusImgsQB> pagingQueryBean);
}
