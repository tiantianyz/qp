/*
 * Powered By Generator Util
 */
package com.qp.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qp.entity.Garages;
import com.qp.entity.PagingInfo;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.querybean.GaragesQB;
import com.qp.persistence.GaragesMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class GaragesComponent {
	
	@Autowired
	private GaragesMapper garagesMapper;

	/**
	 * 插入garages一条记录
	 * 
	 * @param garages 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public Long createGarages(Garages garages) {
		garagesMapper.insert(garages);
		return garages.getGarageId();
	}

	/**
	 * 根据主键删除指定的garages记录
	 * 
	 * @param garageId 主键值
	 */
	public void removeGarages(Long garageId) {
		garagesMapper.delete(garageId);
	}

	/**
	 * 更新指定的garages记录
	 * 
	 * @param garages
	 */
	public void updateGarages(Garages garages) {
		garagesMapper.update(garages);
	}

	/**
	 * 根据主键查询一条garages记录
	 * 
	 * @param garageId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public Garages getGarages(Long garageId) {
		return garagesMapper.select(garageId);
	}

	/**
	 * 根据查询对象查询garages结果列表
	 * 
	 * @return  garages记录列表
	 */
	public List<Garages> getGaragess(GaragesQB queryBean) {
		return garagesMapper.selectList(queryBean);
	}

	/**
	 * 查询所有garages记录
	 * 
	 * @return 所有 garages记录
	 */
	public List<Garages> getAllGaragess() {
		return garagesMapper.selectList(null);
	}

	/**
	 * 分页查询所有garages记录
	 * 
	 * @return 当前页的 garages记录
	 */
	public PagingResultBean<List<Garages>> getAllGaragessPaging(PagingQueryBean<GaragesQB> pagingQueryBean) {
		// 分页查询列表
		List<Garages> garagesList = garagesMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<Garages>> result = new PagingResultBean<List<Garages>>();
		result.setResultList(garagesList);

		// 查询记录数
		Integer count = garagesMapper.selectCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);

		return result;
	}
	/**
	 * 分页查询所有garages记录
	 * 
	 * @return 当前页的 garages记录
	 */
	public PagingResultBean<List<Garages>> getGarageW(PagingQueryBean<GaragesQB> pagingQueryBean) {
		// 分页查询列表
		List<Garages> garagesList = garagesMapper.selectWPage(pagingQueryBean);
		PagingResultBean<List<Garages>> result = new PagingResultBean<List<Garages>>();
		result.setResultList(garagesList);
		
		// 查询记录数
		Integer count = garagesMapper.selectCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);
		
		return result;
	}

	/**
	 * 存储过程调用
	 * 
	 * @return
	 */
	public void proc(Garages Garages) {
		garagesMapper.proc(Garages);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setGaragesMapper(GaragesMapper garagesMapper) {
		this.garagesMapper = garagesMapper;
	}
}
