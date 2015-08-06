/*
 * Powered By Generator Util
 */
package com.qp.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattsoft.baseplatform.core.entity.PagingInfo;
import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.cattsoft.baseplatform.core.entity.PagingResultBean;
import com.qp.entity.AdminDivision;
import com.qp.entity.querybean.AdminDivisionQB;
import com.qp.persistence.AdminDivisionMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class AdminDivisionComponent {
	
	@Autowired
	private AdminDivisionMapper adminDivisionMapper;

	/**
	 * 插入admin_division一条记录
	 * 
	 * @param adminDivision 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public Long createAdminDivision(AdminDivision adminDivision) {
		adminDivisionMapper.insert(adminDivision);
		return adminDivision.getDivisionId();
	}

	/**
	 * 根据主键删除指定的admin_division记录
	 * 
	 * @param divisionId 主键值
	 */
	public void removeAdminDivision(Long divisionId) {
		adminDivisionMapper.delete(divisionId);
	}

	/**
	 * 更新指定的admin_division记录
	 * 
	 * @param adminDivision
	 */
	public void updateAdminDivision(AdminDivision adminDivision) {
		adminDivisionMapper.update(adminDivision);
	}

	/**
	 * 根据主键查询一条admin_division记录
	 * 
	 * @param divisionId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public AdminDivision getAdminDivision(Long divisionId) {
		return adminDivisionMapper.select(divisionId);
	}

	/**
	 * 根据查询对象查询admin_division结果列表
	 * 
	 * @return  admin_division记录列表
	 */
	public List<AdminDivision> getAdminDivisions(AdminDivisionQB queryBean) {
		return adminDivisionMapper.selectList(queryBean);
	}

	/**
	 * 查询所有admin_division记录
	 * 
	 * @return 所有 admin_division记录
	 */
	public List<AdminDivision> getAllAdminDivisions() {
		return adminDivisionMapper.selectList(null);
	}

	/**
	 * 分页查询所有admin_division记录
	 * 
	 * @return 当前页的 admin_division记录
	 */
	public PagingResultBean<List<AdminDivision>> getAllAdminDivisionsPaging(PagingQueryBean<AdminDivisionQB> pagingQueryBean) {
		// 分页查询列表
		List<AdminDivision> adminDivisionList = adminDivisionMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<AdminDivision>> result = new PagingResultBean<List<AdminDivision>>();
		result.setResultList(adminDivisionList);

		// 查询记录数
		Integer count = adminDivisionMapper.selectCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);

		return result;
	}

	/**
	 * 存储过程调用
	 * 
	 * @return
	 */
	public void proc(AdminDivision AdminDivision) {
		adminDivisionMapper.proc(AdminDivision);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setAdminDivisionMapper(AdminDivisionMapper adminDivisionMapper) {
		this.adminDivisionMapper = adminDivisionMapper;
	}
}
