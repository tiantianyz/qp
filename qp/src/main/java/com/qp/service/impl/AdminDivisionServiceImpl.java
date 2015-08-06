/*
 * Powered By Generator Util
 */
package com.qp.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.cattsoft.baseplatform.core.entity.PagingResultBean;
import com.qp.component.AdminDivisionComponent;
import com.qp.entity.AdminDivision;
import com.qp.entity.querybean.AdminDivisionQB;
import com.qp.service.AdminDivisionService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("adminDivisionService")
@Transactional
public class AdminDivisionServiceImpl implements AdminDivisionService {
	
	Log log = LogFactory.getLog(AdminDivisionServiceImpl.class);
	
	@Autowired
	private AdminDivisionComponent adminDivisionComponent;

	@Override
	public Long createAdminDivision(AdminDivision adminDivision) {
		return adminDivisionComponent.createAdminDivision(adminDivision);
	}

	@Override
	public void updateAdminDivision(AdminDivision adminDivision) {
		adminDivisionComponent.updateAdminDivision(adminDivision);
	}

	@Override
	public void removeAdminDivision(Long divisionId) {
		adminDivisionComponent.removeAdminDivision(divisionId);
	}

	@Transactional(readOnly = true)
	@Override
	public AdminDivision getAdminDivision(Long divisionId) {
		return adminDivisionComponent.getAdminDivision(divisionId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<AdminDivision> getAllAdminDivisions() {
		return adminDivisionComponent.getAllAdminDivisions();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<AdminDivision> getAdminDivisions(AdminDivisionQB queryBean) {
		return adminDivisionComponent.getAdminDivisions(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<AdminDivision>> getAllAdminDivisionsPaging(PagingQueryBean<AdminDivisionQB> qb) {
		return adminDivisionComponent.getAllAdminDivisionsPaging(qb);
	}
	
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setAdminDivisionComponent(AdminDivisionComponent adminDivisionComponent) {
		this.adminDivisionComponent = adminDivisionComponent;
	}
}
