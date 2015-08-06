/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;
import com.qp.entity.Customer;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.querybean.CustomerQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@MyBatisRepository
public interface CustomerMapper {
	void insert(Customer customer);

	void delete(Long cusId);

	void update(Customer customer);

	Customer select(Long cusId);

	List<Customer> selectList(CustomerQB queryBean);

	List<Customer> selectPage(PagingQueryBean<CustomerQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<CustomerQB> pagingQueryBean);
	
	List<Customer> selectInp(PagingQueryBean<CustomerQB> pagingQueryBean);
	
	Integer selectInpCount(PagingQueryBean<CustomerQB> pagingQueryBean);

	Object proc(Customer customer);
	Long findMaxPhone();
	List<Customer> selectCols(CustomerQB queryBean);
}