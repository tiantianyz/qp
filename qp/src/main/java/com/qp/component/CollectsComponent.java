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
import com.qp.entity.Collects;
import com.qp.entity.querybean.CollectsQB;
import com.qp.persistence.CollectsMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class CollectsComponent {
	
	@Autowired
	private CollectsMapper collectsMapper;

	/**
	 * 插入collects一条记录
	 * 
	 * @param collects 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public void createCollects(Collects collects) {
		collectsMapper.insert(collects);
	}

	/**
	 * 根据主键删除指定的collects记录
	 * 
	 * @param openId 主键值
	 */
	public void removeCollects(Collects collects) {
		collectsMapper.delete(collects);
	}

	/**
	 * 更新指定的collects记录
	 * 
	 * @param collects
	 */
	public void updateCollects(Collects collects) {
		collectsMapper.update(collects);
	}

	/**
	 * 根据主键查询一条collects记录
	 * 
	 * @param openId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public Collects getCollects(Long openId) {
		return collectsMapper.select(openId);
	}

	/**
	 * 根据查询对象查询collects结果列表
	 * 
	 * @return  collects记录列表
	 */
	public List<Collects> getCollectss(CollectsQB queryBean) {
		return collectsMapper.selectList(queryBean);
	}

	/**
	 * 查询所有collects记录
	 * 
	 * @return 所有 collects记录
	 */
	public List<Collects> getAllCollectss() {
		return collectsMapper.selectList(null);
	}

	/**
	 * 分页查询所有collects记录
	 * 
	 * @return 当前页的 collects记录
	 */
	public PagingResultBean<List<Collects>> getAllCollectssPaging(PagingQueryBean<CollectsQB> pagingQueryBean) {
		// 分页查询列表
		List<Collects> collectsList = collectsMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<Collects>> result = new PagingResultBean<List<Collects>>();
		result.setResultList(collectsList);

		// 查询记录数
		Integer count = collectsMapper.selectCount(pagingQueryBean);
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
	public void proc(Collects Collects) {
		collectsMapper.proc(Collects);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setCollectsMapper(CollectsMapper collectsMapper) {
		this.collectsMapper = collectsMapper;
	}
}
