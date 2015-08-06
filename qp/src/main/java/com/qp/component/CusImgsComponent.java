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
import com.qp.entity.CusImgs;
import com.qp.entity.querybean.CusImgsQB;
import com.qp.persistence.CusImgsMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class CusImgsComponent {
	
	@Autowired
	private CusImgsMapper cusImgsMapper;

	/**
	 * 插入cus_imgs一条记录
	 * 
	 * @param cusImgs 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public Long createCusImgs(CusImgs cusImgs) {
		cusImgsMapper.insert(cusImgs);
		return cusImgs.getCusImgId();
	}

	/**
	 * 根据主键删除指定的cus_imgs记录
	 * 
	 * @param cusImgId 主键值
	 */
	public void removeCusImgs(Long cusImgId) {
		cusImgsMapper.delete(cusImgId);
	}

	/**
	 * 更新指定的cus_imgs记录
	 * 
	 * @param cusImgs
	 */
	public void updateCusImgs(CusImgs cusImgs) {
		cusImgsMapper.update(cusImgs);
	}

	/**
	 * 根据主键查询一条cus_imgs记录
	 * 
	 * @param cusImgId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public CusImgs getCusImgs(Long cusImgId) {
		return cusImgsMapper.select(cusImgId);
	}

	/**
	 * 根据查询对象查询cus_imgs结果列表
	 * 
	 * @return  cus_imgs记录列表
	 */
	public List<CusImgs> getCusImgss(CusImgsQB queryBean) {
		return cusImgsMapper.selectList(queryBean);
	}

	/**
	 * 查询所有cus_imgs记录
	 * 
	 * @return 所有 cus_imgs记录
	 */
	public List<CusImgs> getAllCusImgss() {
		return cusImgsMapper.selectList(null);
	}

	/**
	 * 分页查询所有cus_imgs记录
	 * 
	 * @return 当前页的 cus_imgs记录
	 */
	public PagingResultBean<List<CusImgs>> getAllCusImgssPaging(PagingQueryBean<CusImgsQB> pagingQueryBean) {
		// 分页查询列表
		List<CusImgs> cusImgsList = cusImgsMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<CusImgs>> result = new PagingResultBean<List<CusImgs>>();
		result.setResultList(cusImgsList);

		// 查询记录数
		Integer count = cusImgsMapper.selectCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);

		return result;
	}
	public int deleteByCusId(Long cusId)throws Exception{
		return cusImgsMapper.deleteByCusId(cusId);
	}
	
	
	/**
	 * 存储过程调用
	 * 
	 * @return
	 */
	public void proc(CusImgs CusImgs) {
		cusImgsMapper.proc(CusImgs);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setCusImgsMapper(CusImgsMapper cusImgsMapper) {
		this.cusImgsMapper = cusImgsMapper;
	}
	
	
}
