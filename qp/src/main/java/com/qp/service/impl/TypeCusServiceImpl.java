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

import com.qp.component.TypeCusComponent;
import com.qp.entity.Customer;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeCus;
import com.qp.entity.querybean.TypeCusQB;
import com.qp.service.TypeCusService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("typeCusService")
@Transactional
public class TypeCusServiceImpl implements TypeCusService {
	
	Log log = LogFactory.getLog(TypeCusServiceImpl.class);
	
	@Autowired
	private TypeCusComponent typeCusComponent;

	@Override
	public Long createTypeCus(TypeCus typeCus) {
		return typeCusComponent.createTypeCus(typeCus);
	}

	@Override
	public void updateTypeCus(TypeCus typeCus) {
		typeCusComponent.updateTypeCus(typeCus);
	}

	@Override
	public void removeTypeCus(Long typeCusId) {
		typeCusComponent.removeTypeCus(typeCusId);
	}

	@Transactional(readOnly = true)
	@Override
	public TypeCus getTypeCus(Long typeCusId) {
		return typeCusComponent.getTypeCus(typeCusId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TypeCus> getAllTypeCuss() {
		return typeCusComponent.getAllTypeCuss();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<TypeCus> getTypeCuss(TypeCusQB queryBean) {
		return typeCusComponent.getTypeCuss(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<TypeCus>> getAllTypeCussPaging(PagingQueryBean<TypeCusQB> qb) {
		return typeCusComponent.getAllTypeCussPaging(qb);
	}
	
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setTypeCusComponent(TypeCusComponent typeCusComponent) {
		this.typeCusComponent = typeCusComponent;
	}

	@Override
	public PagingResultBean<List<Customer>> queryComplex(
			PagingQueryBean<TypeCusQB> pagingQueryBean) {
		return typeCusComponent.queryComplex(pagingQueryBean);
	}

	@Override
	public Long getMaxOrder(Long typeId) {
		return typeCusComponent.getMaxOrder(typeId);
	}
}
