/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeCus;
import com.qp.entity.Types;
import com.qp.entity.querybean.TypesQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface TypesService {
	/**
	 * 增加types信息
	 * 
	 * @param types types信息
	 *
	 * @return types标识
	 */
	Long createTypes(Types types);

	/**
	 * 修改types信息
	 * 
	 * @param types types信息
	 */
	void updateTypes(Types types);

	/**
	 * 删除types信息
	 * 
	 * @param typesId types标识
	 */
	void removeTypes(Long typesId);

	/**
	 * 获取types信息
	 * 
	 * @param typesId types标识
	 * @return types信息
	 */
	Types getTypes(Long typesId);

	/**
	 * 获取所有types
	 * 
	 * @return 所有types信息的列表
	 */
	List<Types> getAllTypess();
	
	/**
	 * 根据查询对象查询types结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  types记录列表
	 */
	List<Types> getTypess(TypesQB queryBean);

	/**
	 * 分页获取types列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页types列表
	 */
	PagingResultBean<List<Types>> getAllTypessPaging(PagingQueryBean<TypesQB> pagingQueryBean);
	/**
	 * 分页获取types列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页types列表
	 */
	PagingResultBean<List<TypeCus>> getComplexPaging(PagingQueryBean<TypesQB> pagingQueryBean);
	
}
