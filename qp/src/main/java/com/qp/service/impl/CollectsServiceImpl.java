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
import com.qp.component.CollectsComponent;
import com.qp.entity.Collects;
import com.qp.entity.querybean.CollectsQB;
import com.qp.service.CollectsService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("collectsService")
@Transactional
public class CollectsServiceImpl implements CollectsService {
	
	Log log = LogFactory.getLog(CollectsServiceImpl.class);
	
	@Autowired
	private CollectsComponent collectsComponent;

	@Override
	public void createCollects(Collects collects) {
		collectsComponent.createCollects(collects);
	}

	@Override
	public void updateCollects(Collects collects) {
		collectsComponent.updateCollects(collects);
	}

	@Override
	public void removeCollects(Collects collects) {
		collectsComponent.removeCollects(collects);
	}

	@Transactional(readOnly = true)
	@Override
	public Collects getCollects(Long openId) {
		return collectsComponent.getCollects(openId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Collects> getAllCollectss() {
		return collectsComponent.getAllCollectss();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Collects> getCollectss(CollectsQB queryBean) {
		return collectsComponent.getCollectss(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<Collects>> getAllCollectssPaging(PagingQueryBean<CollectsQB> qb) {
		return collectsComponent.getAllCollectssPaging(qb);
	}
	
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setCollectsComponent(CollectsComponent collectsComponent) {
		this.collectsComponent = collectsComponent;
	}
}
