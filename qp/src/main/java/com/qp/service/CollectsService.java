/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.cattsoft.baseplatform.core.entity.PagingResultBean;
import com.qp.entity.Collects;
import com.qp.entity.querybean.CollectsQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface CollectsService {
	/**
	 * 增加collects信息
	 * 
	 * @param collects collects信息
	 *
	 * @return collects标识
	 */
	void createCollects(Collects collects);

	/**
	 * 修改collects信息
	 * 
	 * @param collects collects信息
	 */
	void updateCollects(Collects collects);

	/**
	 * 删除collects信息
	 * 
	 * @param openId collects标识
	 */
	void removeCollects(Collects collects);

	/**
	 * 获取collects信息
	 * 
	 * @param openId collects标识
	 * @return collects信息
	 */
	Collects getCollects(Long openId);

	/**
	 * 获取所有collects
	 * 
	 * @return 所有collects信息的列表
	 */
	List<Collects> getAllCollectss();
	
	/**
	 * 根据查询对象查询collects结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  collects记录列表
	 */
	List<Collects> getCollectss(CollectsQB queryBean);

	/**
	 * 分页获取collects列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页collects列表
	 */
	PagingResultBean<List<Collects>> getAllCollectssPaging(PagingQueryBean<CollectsQB> pagingQueryBean);
}
