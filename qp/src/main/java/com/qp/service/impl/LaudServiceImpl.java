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
import com.qp.component.LaudComponent;
import com.qp.entity.Laud;
import com.qp.entity.querybean.LaudQB;
import com.qp.service.LaudService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("laudService")
@Transactional
public class LaudServiceImpl implements LaudService {
	
	Log log = LogFactory.getLog(LaudServiceImpl.class);
	
	@Autowired
	private LaudComponent laudComponent;

	@Override
	public void createLaud(Laud laud) {
		laudComponent.createLaud(laud);
	}

	@Override
	public void updateLaud(Laud laud) {
		laudComponent.updateLaud(laud);
	}

	@Override
	public void removeLaud(Laud laud) {
		laudComponent.removeLaud(laud);
	}

	@Transactional(readOnly = true)
	@Override
	public Laud getLaud(Long openId) {
		return laudComponent.getLaud(openId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Laud> getAllLauds() {
		return laudComponent.getAllLauds();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Laud> getLauds(LaudQB queryBean) {
		return laudComponent.getLauds(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<Laud>> getAllLaudsPaging(PagingQueryBean<LaudQB> qb) {
		return laudComponent.getAllLaudsPaging(qb);
	}
	
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setLaudComponent(LaudComponent laudComponent) {
		this.laudComponent = laudComponent;
	}
}
