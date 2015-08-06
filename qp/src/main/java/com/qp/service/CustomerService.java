/*
 * Powered By Generator Util
 */
package com.qp.service;

import java.util.List;

import com.qp.entity.CusImgs;
import com.qp.entity.Customer;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.querybean.CustomerQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
public interface CustomerService {
	/**
	 * 增加customer信息
	 * 
	 * @param customer customer信息
	 *
	 * @return customer标识
	 */
	Long createCustomer(Customer customer)throws Exception;
	
	Long createOne(Customer customer,List<CusImgs> cusImgs)throws Exception;

	/**
	 * 修改customer信息
	 * 
	 * @param customer customer信息
	 */
	void updateCustomer(Customer customer)throws Exception;

	/**
	 * 删除customer信息
	 * 
	 * @param cusId customer标识
	 */
	void removeCustomer(Long cusId)throws Exception;

	/**
	 * 获取customer信息
	 * 
	 * @param cusId customer标识
	 * @return customer信息
	 */
	Customer getCustomer(Long cusId)throws Exception;

	/**
	 * 获取所有customer
	 * 
	 * @return 所有customer信息的列表
	 */
	List<Customer> getAllCustomers()throws Exception;
	
	/**
	 * 根据查询对象查询customer结果列表
	 * @param queryBean  查询对象
	 *
	 * @return  customer记录列表
	 */
	List<Customer> getCustomers(CustomerQB queryBean)throws Exception;

	/**
	 * 分页获取customer列表
	 * 
	 * @param pagingQueryBean  分页查询对象
	 *
	 * @return 分页customer列表
	 */
	PagingResultBean<List<Customer>> getAllCustomersPaging(PagingQueryBean<CustomerQB> pagingQueryBean)throws Exception;
	PagingResultBean<List<Customer>> getCusInqPaging(PagingQueryBean<CustomerQB> pagingQueryBean)throws Exception;
	
	Long findMaxPhone()throws Exception;
	public List<Customer> selectCols(CustomerQB queryBean);
}
