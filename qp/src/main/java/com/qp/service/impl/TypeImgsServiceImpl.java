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

import com.qp.component.TypeImgsComponent;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeImgs;
import com.qp.entity.querybean.TypeImgsQB;
import com.qp.service.TypeImgsService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("typeImgsService")
@Transactional
public class TypeImgsServiceImpl implements TypeImgsService {
	
	Log log = LogFactory.getLog(TypeImgsServiceImpl.class);
	
	@Autowired
	private TypeImgsComponent typeImgsComponent;

	@Override
	public Long createTypeImgs(TypeImgs typeImgs) {
		return typeImgsComponent.createTypeImgs(typeImgs);
	}

	@Override
	public void updateTypeImgs(TypeImgs typeImgs) {
		typeImgsComponent.updateTypeImgs(typeImgs);
	}

	@Override
	public void removeTypeImgs(Long typeImgId) {
		typeImgsComponent.removeTypeImgs(typeImgId);
	}

	@Transactional(readOnly = true)
	@Override
	public TypeImgs getTypeImgs(Long typeImgId) {
		return typeImgsComponent.getTypeImgs(typeImgId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TypeImgs> getAllTypeImgss() {
		return typeImgsComponent.getAllTypeImgss();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<TypeImgs> getTypeImgss(TypeImgsQB queryBean) {
		return typeImgsComponent.getTypeImgss(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<TypeImgs>> getAllTypeImgssPaging(PagingQueryBean<TypeImgsQB> qb) {
		return typeImgsComponent.getAllTypeImgssPaging(qb);
	}
	
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setTypeImgsComponent(TypeImgsComponent typeImgsComponent) {
		this.typeImgsComponent = typeImgsComponent;
	}
}
