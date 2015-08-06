/*
 * Powered By Generator Util
 */
package com.qp.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cattsoft.baseplatform.core.entity.PagingInfo;
import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.cattsoft.baseplatform.core.entity.PagingResultBean;
import com.qp.entity.Laud;
import com.qp.entity.querybean.LaudQB;
import com.qp.persistence.LaudMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class LaudComponent {
	
	@Autowired
	private LaudMapper laudMapper;

	/**
	 * 插入laud一条记录
	 * 
	 * @param laud 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public void createLaud(Laud laud) {
		laudMapper.insert(laud);
	}

	/**
	 * 根据主键删除指定的laud记录
	 * 
	 * @param openId 主键值
	 */
	public void removeLaud(Laud laud) {
		laudMapper.delete(laud);
	}

	/**
	 * 更新指定的laud记录
	 * 
	 * @param laud
	 */
	public void updateLaud(Laud laud) {
		laudMapper.update(laud);
	}

	/**
	 * 根据主键查询一条laud记录
	 * 
	 * @param openId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public Laud getLaud(Long openId) {
		return laudMapper.select(openId);
	}

	/**
	 * 根据查询对象查询laud结果列表
	 * 
	 * @return  laud记录列表
	 */
	public List<Laud> getLauds(LaudQB queryBean) {
		return laudMapper.selectList(queryBean);
	}

	/**
	 * 查询所有laud记录
	 * 
	 * @return 所有 laud记录
	 */
	public List<Laud> getAllLauds() {
		return laudMapper.selectList(null);
	}

	/**
	 * 分页查询所有laud记录
	 * 
	 * @return 当前页的 laud记录
	 */
	public PagingResultBean<List<Laud>> getAllLaudsPaging(PagingQueryBean<LaudQB> pagingQueryBean) {
		// 分页查询列表
		List<Laud> laudList = laudMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<Laud>> result = new PagingResultBean<List<Laud>>();
		result.setResultList(laudList);

		// 查询记录数
		Integer count = laudMapper.selectCount(pagingQueryBean);
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
	public void proc(Laud laud) {
		laudMapper.proc(laud);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setLaudMapper(LaudMapper laudMapper) {
		this.laudMapper = laudMapper;
	}
}
