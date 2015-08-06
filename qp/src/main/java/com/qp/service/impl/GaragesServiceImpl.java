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

import com.qp.component.GaragesComponent;
import com.qp.entity.Garages;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.querybean.GaragesQB;
import com.qp.service.GaragesService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("garagesService")
@Transactional
public class GaragesServiceImpl implements GaragesService {
	
	Log log = LogFactory.getLog(GaragesServiceImpl.class);
	
	@Autowired
	private GaragesComponent garagesComponent;

	@Override
	public Long createGarages(Garages garages) {
		return garagesComponent.createGarages(garages);
	}

	@Override
	public void updateGarages(Garages garages) {
		garagesComponent.updateGarages(garages);
	}

	@Override
	public void removeGarages(Long garageId) {
		garagesComponent.removeGarages(garageId);
	}

	@Transactional(readOnly = true)
	@Override
	public Garages getGarages(Long garageId) {
		return garagesComponent.getGarages(garageId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Garages> getAllGaragess() {
		return garagesComponent.getAllGaragess();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Garages> getGaragess(GaragesQB queryBean) {
		return garagesComponent.getGaragess(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<Garages>> getAllGaragessPaging(PagingQueryBean<GaragesQB> qb) {
		return garagesComponent.getAllGaragessPaging(qb);
	}
	
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setGaragesComponent(GaragesComponent garagesComponent) {
		this.garagesComponent = garagesComponent;
	}

	@Override
	public PagingResultBean<List<Garages>> getGarageW(
			PagingQueryBean<GaragesQB> pagingQueryBean) {
		return garagesComponent.getGarageW(pagingQueryBean);
	}
}
