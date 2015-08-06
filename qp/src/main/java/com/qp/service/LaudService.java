/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.cattsoft.baseplatform.core.entity.PagingResultBean;
import com.qp.entity.Laud;
import com.qp.entity.querybean.LaudQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface LaudService {
	/**
	 * 增加laud信息
	 * 
	 * @param laud laud信息
	 *
	 * @return laud标识
	 */
	void createLaud(Laud laud);

	/**
	 * 修改laud信息
	 * 
	 * @param laud laud信息
	 */
	void updateLaud(Laud laud);

	/**
	 * 删除laud信息
	 * 
	 * @param openId laud标识
	 */
	void removeLaud(Laud laud);

	/**
	 * 获取laud信息
	 * 
	 * @param openId laud标识
	 * @return laud信息
	 */
	Laud getLaud(Long openId);

	/**
	 * 获取所有laud
	 * 
	 * @return 所有laud信息的列表
	 */
	List<Laud> getAllLauds();
	
	/**
	 * 根据查询对象查询laud结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  laud记录列表
	 */
	List<Laud> getLauds(LaudQB queryBean);

	/**
	 * 分页获取laud列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页laud列表
	 */
	PagingResultBean<List<Laud>> getAllLaudsPaging(PagingQueryBean<LaudQB> pagingQueryBean);
}
