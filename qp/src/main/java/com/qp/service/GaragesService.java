/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.qp.entity.Garages;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.querybean.GaragesQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface GaragesService {
	/**
	 * 增加garages信息
	 * 
	 * @param garages garages信息
	 *
	 * @return garages标识
	 */
	Long createGarages(Garages garages);

	/**
	 * 修改garages信息
	 * 
	 * @param garages garages信息
	 */
	void updateGarages(Garages garages);

	/**
	 * 删除garages信息
	 * 
	 * @param garageId garages标识
	 */
	void removeGarages(Long garageId);

	/**
	 * 获取garages信息
	 * 
	 * @param garageId garages标识
	 * @return garages信息
	 */
	Garages getGarages(Long garageId);

	/**
	 * 获取所有garages
	 * 
	 * @return 所有garages信息的列表
	 */
	List<Garages> getAllGaragess();
	
	/**
	 * 根据查询对象查询garages结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  garages记录列表
	 */
	List<Garages> getGaragess(GaragesQB queryBean);

	/**
	 * 分页获取garages列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页garages列表
	 */
	PagingResultBean<List<Garages>> getAllGaragessPaging(PagingQueryBean<GaragesQB> pagingQueryBean);
	PagingResultBean<List<Garages>> getGarageW(PagingQueryBean<GaragesQB> pagingQueryBean);
}
