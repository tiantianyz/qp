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
import com.qp.entity.TypeCus;
import com.qp.entity.Types;
import com.qp.entity.querybean.TypesQB;
import com.qp.persistence.TypesMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class TypesComponent {
	
	@Autowired
	private TypesMapper typesMapper;

	/**
	 * 插入types一条记录
	 * 
	 * @param types 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public Long createTypes(Types types) {
		typesMapper.insert(types);
		return types.getTypesId();
	}

	/**
	 * 根据主键删除指定的types记录
	 * 
	 * @param typesId 主键值
	 */
	public void removeTypes(Long typesId) {
		typesMapper.delete(typesId);
	}

	/**
	 * 更新指定的types记录
	 * 
	 * @param types
	 */
	public void updateTypes(Types types) {
		typesMapper.update(types);
	}

	/**
	 * 根据主键查询一条types记录
	 * 
	 * @param typesId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public Types getTypes(Long typesId) {
		return typesMapper.select(typesId);
	}

	/**
	 * 根据查询对象查询types结果列表
	 * 
	 * @return  types记录列表
	 */
	public List<Types> getTypess(TypesQB queryBean) {
		return typesMapper.selectList(queryBean);
	}

	/**
	 * 查询所有types记录
	 * 
	 * @return 所有 types记录
	 */
	public List<Types> getAllTypess() {
		return typesMapper.selectList(null);
	}

	/**
	 * 分页查询所有types记录
	 * 
	 * @return 当前页的 types记录
	 */
	public PagingResultBean<List<Types>> getAllTypessPaging(PagingQueryBean<TypesQB> pagingQueryBean) {
		// 分页查询列表
		List<Types> typesList = typesMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<Types>> result = new PagingResultBean<List<Types>>();
		result.setResultList(typesList);

		// 查询记录数
		Integer count = typesMapper.selectCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);

		return result;
	}
	/**
	 * 分页查询所有types记录
	 * 
	 * @return 当前页的 types记录
	 */
	public PagingResultBean<List<TypeCus>> getComplexPaging(PagingQueryBean<TypesQB> pagingQueryBean) {
		// 分页查询列表
		List<TypeCus> typesList = typesMapper.selectComplex(pagingQueryBean);
		PagingResultBean<List<TypeCus>> result = new PagingResultBean<List<TypeCus>>();
		result.setResultList(typesList);
		
		// 查询记录数
		Integer count = typesMapper.selectComplexCount(pagingQueryBean);
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
	public void proc(Types Types) {
		typesMapper.proc(Types);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setTypesMapper(TypesMapper typesMapper) {
		this.typesMapper = typesMapper;
	}
}
