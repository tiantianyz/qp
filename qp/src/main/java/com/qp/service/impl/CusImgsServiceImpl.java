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
import com.qp.component.CusImgsComponent;
import com.qp.entity.CusImgs;
import com.qp.entity.querybean.CusImgsQB;
import com.qp.service.CusImgsService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("cusImgsService")
@Transactional
public class CusImgsServiceImpl implements CusImgsService {
	
	Log log = LogFactory.getLog(CusImgsServiceImpl.class);
	
	@Autowired
	private CusImgsComponent cusImgsComponent;

	@Override
	public Long createCusImgs(CusImgs cusImgs) {
		return cusImgsComponent.createCusImgs(cusImgs);
	}

	@Override
	public void updateCusImgs(CusImgs cusImgs) {
		cusImgsComponent.updateCusImgs(cusImgs);
	}

	@Override
	public void removeCusImgs(Long cusImgId) {
		cusImgsComponent.removeCusImgs(cusImgId);
	}

	@Transactional(readOnly = true)
	@Override
	public CusImgs getCusImgs(Long cusImgId) {
		return cusImgsComponent.getCusImgs(cusImgId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CusImgs> getAllCusImgss() {
		return cusImgsComponent.getAllCusImgss();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<CusImgs> getCusImgss(CusImgsQB queryBean) {
		return cusImgsComponent.getCusImgss(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<CusImgs>> getAllCusImgssPaging(PagingQueryBean<CusImgsQB> qb) {
		return cusImgsComponent.getAllCusImgssPaging(qb);
	}
	
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setCusImgsComponent(CusImgsComponent cusImgsComponent) {
		this.cusImgsComponent = cusImgsComponent;
	}
}
