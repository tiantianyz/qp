/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeImgs;
import com.qp.entity.querybean.TypeImgsQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface TypeImgsService {
	/**
	 * 增加type_imgs信息
	 * 
	 * @param typeImgs type_imgs信息
	 *
	 * @return type_imgs标识
	 */
	Long createTypeImgs(TypeImgs typeImgs);

	/**
	 * 修改type_imgs信息
	 * 
	 * @param typeImgs type_imgs信息
	 */
	void updateTypeImgs(TypeImgs typeImgs);

	/**
	 * 删除type_imgs信息
	 * 
	 * @param typeImgId type_imgs标识
	 */
	void removeTypeImgs(Long typeImgId);

	/**
	 * 获取type_imgs信息
	 * 
	 * @param typeImgId type_imgs标识
	 * @return type_imgs信息
	 */
	TypeImgs getTypeImgs(Long typeImgId);

	/**
	 * 获取所有type_imgs
	 * 
	 * @return 所有type_imgs信息的列表
	 */
	List<TypeImgs> getAllTypeImgss();
	
	/**
	 * 根据查询对象查询type_imgs结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  type_imgs记录列表
	 */
	List<TypeImgs> getTypeImgss(TypeImgsQB queryBean);

	/**
	 * 分页获取type_imgs列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页type_imgs列表
	 */
	PagingResultBean<List<TypeImgs>> getAllTypeImgssPaging(PagingQueryBean<TypeImgsQB> pagingQueryBean);
}
