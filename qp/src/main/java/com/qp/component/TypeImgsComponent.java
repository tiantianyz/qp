/*
 * Powered By Generator Util
 */
package com.qp.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qp.entity.PagingInfo;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeImgs;
import com.qp.entity.querybean.TypeImgsQB;
import com.qp.persistence.TypeImgsMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class TypeImgsComponent {
	
	@Autowired
	private TypeImgsMapper typeImgsMapper;

	/**
	 * 插入type_imgs一条记录
	 * 
	 * @param typeImgs 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public Long createTypeImgs(TypeImgs typeImgs) {
		typeImgsMapper.insert(typeImgs);
		return typeImgs.getTypeImgId();
	}

	/**
	 * 根据主键删除指定的type_imgs记录
	 * 
	 * @param typeImgId 主键值
	 */
	public void removeTypeImgs(Long typeImgId) {
		typeImgsMapper.delete(typeImgId);
	}

	/**
	 * 更新指定的type_imgs记录
	 * 
	 * @param typeImgs
	 */
	public void updateTypeImgs(TypeImgs typeImgs) {
		typeImgsMapper.update(typeImgs);
	}

	/**
	 * 根据主键查询一条type_imgs记录
	 * 
	 * @param typeImgId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public TypeImgs getTypeImgs(Long typeImgId) {
		return typeImgsMapper.select(typeImgId);
	}

	/**
	 * 根据查询对象查询type_imgs结果列表
	 * 
	 * @return  type_imgs记录列表
	 */
	public List<TypeImgs> getTypeImgss(TypeImgsQB queryBean) {
		return typeImgsMapper.selectList(queryBean);
	}

	/**
	 * 查询所有type_imgs记录
	 * 
	 * @return 所有 type_imgs记录
	 */
	public List<TypeImgs> getAllTypeImgss() {
		return typeImgsMapper.selectList(null);
	}

	/**
	 * 分页查询所有type_imgs记录
	 * 
	 * @return 当前页的 type_imgs记录
	 */
	public PagingResultBean<List<TypeImgs>> getAllTypeImgssPaging(PagingQueryBean<TypeImgsQB> pagingQueryBean) {
		// 分页查询列表
		List<TypeImgs> typeImgsList = typeImgsMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<TypeImgs>> result = new PagingResultBean<List<TypeImgs>>();
		result.setResultList(typeImgsList);

		// 查询记录数
		Integer count = typeImgsMapper.selectCount(pagingQueryBean);
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
	public void proc(TypeImgs TypeImgs) {
		typeImgsMapper.proc(TypeImgs);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setTypeImgsMapper(TypeImgsMapper typeImgsMapper) {
		this.typeImgsMapper = typeImgsMapper;
	}
}
