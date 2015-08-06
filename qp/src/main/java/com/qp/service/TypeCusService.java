/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.qp.entity.Customer;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeCus;
import com.qp.entity.querybean.TypeCusQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface TypeCusService {
	/**
	 * 增加type_cus信息
	 * 
	 * @param typeCus type_cus信息
	 *
	 * @return type_cus标识
	 */
	Long createTypeCus(TypeCus typeCus);

	/**
	 * 修改type_cus信息
	 * 
	 * @param typeCus type_cus信息
	 */
	void updateTypeCus(TypeCus typeCus);

	/**
	 * 删除type_cus信息
	 * 
	 * @param typeCusId type_cus标识
	 */
	void removeTypeCus(Long typeCusId);

	/**
	 * 获取type_cus信息
	 * 
	 * @param typeCusId type_cus标识
	 * @return type_cus信息
	 */
	TypeCus getTypeCus(Long typeCusId);

	/**
	 * 获取所有type_cus
	 * 
	 * @return 所有type_cus信息的列表
	 */
	List<TypeCus> getAllTypeCuss();
	
	/**
	 * 根据查询对象查询type_cus结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  type_cus记录列表
	 */
	List<TypeCus> getTypeCuss(TypeCusQB queryBean);
	
	public Long getMaxOrder(Long typeId);

	/**
	 * 分页获取type_cus列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页type_cus列表
	 */
	PagingResultBean<List<TypeCus>> getAllTypeCussPaging(PagingQueryBean<TypeCusQB> pagingQueryBean);
	
	PagingResultBean<List<Customer>> queryComplex(PagingQueryBean<TypeCusQB> pagingQueryBean);
}
