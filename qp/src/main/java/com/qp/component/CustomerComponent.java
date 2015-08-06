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
import com.qp.entity.querybean.CustomerQB;
import com.qp.persistence.CustomerMapper;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Component
public class CustomerComponent {
	
	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * 插入customer一条记录
	 * 
	 * @param customer 主键通过SEQUENCE生成，在xml中配置
	 * @return 插入记录的主键
	 */
	public Long createCustomer(Customer customer) {
		customerMapper.insert(customer);
		return customer.getCusId();
	}

	/**
	 * 根据主键删除指定的customer记录
	 * 
	 * @param cusId 主键值
	 */
	public void removeCustomer(Long cusId) {
		customerMapper.delete(cusId);
	}

	/**
	 * 更新指定的customer记录
	 * 
	 * @param customer
	 */
	public void updateCustomer(Customer customer) {
		customerMapper.update(customer);
	}

	/**
	 * 根据主键查询一条customer记录
	 * 
	 * @param cusId 主键值
	 *
	 * @return 查询到的记录，如果无对应记录，返回null
	 */
	public Customer getCustomer(Long cusId) {
		return customerMapper.select(cusId);
	}

	/**
	 * 根据查询对象查询customer结果列表
	 * 
	 * @return  customer记录列表
	 */
	public List<Customer> getCustomers(CustomerQB queryBean) {
		return customerMapper.selectList(queryBean);
	}

	/**
	 * 查询所有customer记录
	 * 
	 * @return 所有 customer记录
	 */
	public List<Customer> getAllCustomers() {
		return customerMapper.selectList(null);
	}

	/**
	 * 分页查询所有customer记录
	 * 
	 * @return 当前页的 customer记录
	 */
	public PagingResultBean<List<Customer>> getAllCustomersPaging(PagingQueryBean<CustomerQB> pagingQueryBean) {
		// 分页查询列表
		List<Customer> customerList = customerMapper.selectPage(pagingQueryBean);
		PagingResultBean<List<Customer>> result = new PagingResultBean<List<Customer>>();
		result.setResultList(customerList);

		// 查询记录数
		Integer count = customerMapper.selectCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);

		return result;
	}
	/**
	 * 分页查询所有customer记录
	 * 
	 * @return 当前页的 customer记录
	 */
	public PagingResultBean<List<Customer>> getCusInqPaging(PagingQueryBean<CustomerQB> pagingQueryBean) {
		// 分页查询列表
		List<Customer> customerList = customerMapper.selectInp(pagingQueryBean);
		PagingResultBean<List<Customer>> result = new PagingResultBean<List<Customer>>();
		result.setResultList(customerList);
		// 查询记录数
		Integer count = customerMapper.selectInpCount(pagingQueryBean);
		PagingInfo pagingInfo = pagingQueryBean.getPagingInfo();
		pagingInfo.setTotalRows(count);
		result.setPagingInfo(pagingInfo);
		return result;
	}
	public Long findMaxPhone(){
		return customerMapper.findMaxPhone();
	}
	
	public List<Customer> selectCols(CustomerQB queryBean){
		return customerMapper.selectCols(queryBean);
	}

	/**
	 * 存储过程调用
	 * 
	 * @return
	 */
	public void proc(Customer Customer) {
		customerMapper.proc(Customer);
	}
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
}
