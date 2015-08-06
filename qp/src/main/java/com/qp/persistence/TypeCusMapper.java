/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;
import com.qp.entity.Customer;
import com.qp.entity.PagingQueryBean;
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
@MyBatisRepository
public interface TypeCusMapper {
	void insert(TypeCus typeCus);

	void delete(Long typeCusId);
	
	void removeTcs(TypeCusQB tcQb);

	void update(TypeCus typeCus);

	TypeCus select(Long typeCusId);

	List<TypeCus> selectList(TypeCusQB queryBean);

	List<TypeCus> selectPage(PagingQueryBean<TypeCusQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<TypeCusQB> pagingQueryBean);

	Object proc(TypeCus typeCus);
	
	List<Customer> selectComplex(PagingQueryBean<TypeCusQB> pagingQueryBean);;
	
	Integer selectComplexCount(PagingQueryBean<TypeCusQB> pagingQueryBean);
	Long getMaxOrder(Long typeId);
}