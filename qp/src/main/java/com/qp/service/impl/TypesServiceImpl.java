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

import com.qp.component.TypesComponent;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeCus;
import com.qp.entity.Types;
import com.qp.entity.querybean.TypesQB;
import com.qp.service.TypesService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("typesService")
@Transactional
public class TypesServiceImpl implements TypesService {
	
	Log log = LogFactory.getLog(TypesServiceImpl.class);
	
	@Autowired
	private TypesComponent typesComponent;

	@Override
	public Long createTypes(Types types) {
		return typesComponent.createTypes(types);
	}

	@Override
	public void updateTypes(Types types) {
		typesComponent.updateTypes(types);
	}

	@Override
	public void removeTypes(Long typesId) {
		typesComponent.removeTypes(typesId);
	}

	@Transactional(readOnly = true)
	@Override
	public Types getTypes(Long typesId) {
		return typesComponent.getTypes(typesId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Types> getAllTypess() {
		return typesComponent.getAllTypess();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Types> getTypess(TypesQB queryBean) {
		return typesComponent.getTypess(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<Types>> getAllTypessPaging(PagingQueryBean<TypesQB> qb) {
		return typesComponent.getAllTypessPaging(qb);
	}
	
	@Override
	public PagingResultBean<List<TypeCus>> getComplexPaging(PagingQueryBean<TypesQB> pagingQueryBean) {
		return typesComponent.getComplexPaging(pagingQueryBean);
	} 
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setTypesComponent(TypesComponent typesComponent) {
		this.typesComponent = typesComponent;
	}

}
