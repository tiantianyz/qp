/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.cattsoft.baseplatform.core.entity.PagingResultBean;
import com.qp.entity.AdminDivision;
import com.qp.entity.querybean.AdminDivisionQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface AdminDivisionService {
	/**
	 * 增加admin_division信息
	 * 
	 * @param adminDivision admin_division信息
	 *
	 * @return admin_division标识
	 */
	Long createAdminDivision(AdminDivision adminDivision);

	/**
	 * 修改admin_division信息
	 * 
	 * @param adminDivision admin_division信息
	 */
	void updateAdminDivision(AdminDivision adminDivision);

	/**
	 * 删除admin_division信息
	 * 
	 * @param divisionId admin_division标识
	 */
	void removeAdminDivision(Long divisionId);

	/**
	 * 获取admin_division信息
	 * 
	 * @param divisionId admin_division标识
	 * @return admin_division信息
	 */
	AdminDivision getAdminDivision(Long divisionId);

	/**
	 * 获取所有admin_division
	 * 
	 * @return 所有admin_division信息的列表
	 */
	List<AdminDivision> getAllAdminDivisions();
	
	/**
	 * 根据查询对象查询admin_division结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  admin_division记录列表
	 */
	List<AdminDivision> getAdminDivisions(AdminDivisionQB queryBean);

	/**
	 * 分页获取admin_division列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页admin_division列表
	 */
	PagingResultBean<List<AdminDivision>> getAllAdminDivisionsPaging(PagingQueryBean<AdminDivisionQB> pagingQueryBean);
}
