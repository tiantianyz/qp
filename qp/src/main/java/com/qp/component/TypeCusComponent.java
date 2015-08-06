/*
 * Powered By Generator Util
 */
package com.qp.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qp.entity.Customer;
import com.qp.entity.PagingInfo;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeCus;
import com.qp.entity.querybean.TypeCusQB;
import com.qp.persistence.TypeCusMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class TypeCusComponent {
	
	@Autowired
	private TypeCusMapper typeCusMapper;

	/**
	 * 插入type_cus一条记录
	 * 
	 * @param typeCus 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public Long createTypeCus(TypeCus typeCus) {
		typeCusMapper.insert(typeCus);
		return typeCus.getTypeCusId();
	}

	/**
	 * 根据主键删除指定的type_cus记录
	 * 
	 * @param typeCusId 主键值
	 */
	public void removeTypeCus(Long typeCusId) {
		typeCusMapper.delete(typeCusId);
	}

	/**
	 * 更新指定的type_cus记录
	 * 
	 * @param typeCus
	 */
	public void updateTypeCus(TypeCus typeCus) {
		typeCusMapper.update(typeCus);
	}

	/**
	 * 根据主键查询一条type_cus记录
	 * 
	 * @param typeCusId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public TypeCus getTypeCus(Long typeCusId) {
		return typeCusMapper.select(typeCusId);
	}

	/**
	 * 根据查询对象查询type_cus结果列表
	 * 
	 * @return  type_cus记录列表
	 */
	public List<TypeCus> getTypeCuss(TypeCusQB queryBean) {
		return typeCusMapper.selectList(queryBean);
	}

	/**
	 * 查询所有type_cus记录
	 * 
	 * @return 所有 type_cus记录
	 */
	public List<TypeCus> getAllTypeCuss() {
		return typeCusMapper.selectList(null);
	}

	/**
	 * 分页查询所有type_cus记录
	 * 
	 * @return 当前页的 type_cus记录
	 */
	public PagingResultBean<List<TypeCus>> getAllTypeCussPaging(PagingQueryBean<TypeCusQB> pagingQueryBean) {
		// 分页查询列表
		List<TypeCus> typeCusList = typeCusMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<TypeCus>> result = new PagingResultBean<List<TypeCus>>();
		result.setResultList(typeCusList);

		// 查询记录数
		Integer count = typeCusMapper.selectCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);

		return result;
	}
	public PagingResultBean<List<Customer>> queryComplex(PagingQueryBean<TypeCusQB> pagingQueryBean) {
		// 分页查询列表
		List<Customer> typeCusList = typeCusMapper.selectComplex(pagingQueryBean);
		PagingResultBean<List<Customer>> result = new PagingResultBean<List<Customer>>();
		result.setResultList(typeCusList);
		
		// 查询记录数
		Integer count = typeCusMapper.selectComplexCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);
		return result;
	}
	public void removeTcs(TypeCusQB tcQb){
		typeCusMapper.removeTcs(tcQb);
	}
	public Long getMaxOrder(Long typeId){
		return typeCusMapper.getMaxOrder(typeId);
	}
	

	/**
	 * 存储过程调用
	 * 
	 * @return
	 */
	public void proc(TypeCus TypeCus) {
		typeCusMapper.proc(TypeCus);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setTypeCusMapper(TypeCusMapper typeCusMapper) {
		this.typeCusMapper = typeCusMapper;
	}
}
