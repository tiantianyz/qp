/*
 * Powered By Generator Util
 */
package com.qp.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qp.component.CusImgsComponent;
import com.qp.component.CustomerComponent;
import com.qp.component.TypeCusComponent;
import com.qp.entity.CusImgs;
import com.qp.entity.Customer;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeCus;
import com.qp.entity.querybean.CustomerQB;
import com.qp.entity.querybean.TypeCusQB;
import com.qp.service.CustomerService;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	Log log = LogFactory.getLog(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerComponent customerComponent;

	@Autowired
	private TypeCusComponent typeCusComponent;

	@Autowired
	private CusImgsComponent cusImgsComponent;
	
	@Override
	public Long createCustomer(Customer customer)throws Exception {
		return customerComponent.createCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer)throws Exception {
		customerComponent.updateCustomer(customer);
	}

	@Override
	public void removeCustomer(Long cusId)throws Exception {
		customerComponent.removeCustomer(cusId);
		TypeCusQB tcQb = new TypeCusQB();
		tcQb.setCusId(cusId);
		typeCusComponent.removeTcs(tcQb);
		cusImgsComponent.deleteByCusId(cusId);
	}

	@Transactional(readOnly = true)
	@Override
	public Customer getCustomer(Long cusId)throws Exception {
		return customerComponent.getCustomer(cusId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> getAllCustomers()throws Exception {
		return customerComponent.getAllCustomers();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Customer> getCustomers(CustomerQB queryBean)throws Exception {
		return customerComponent.getCustomers(queryBean);
	}

	@Transactional(readOnly = true)
	@Override
	public PagingResultBean<List<Customer>> getAllCustomersPaging(PagingQueryBean<CustomerQB> qb)throws Exception {
		return customerComponent.getAllCustomersPaging(qb);
	}
	
	
	/*************************************************************/
	/*                      setter and getter                    */
	/*************************************************************/
	
	public void setCustomerComponent(CustomerComponent customerComponent) {
		this.customerComponent = customerComponent;
	}

	@Override
	public Long createOne(Customer customer,List<CusImgs> cusImgs)throws Exception{
		String scope = customer.getCusScope();
		Long cusId=customer.getCusId();
		if(cusId==null){
			cusId = customerComponent.createCustomer(customer);
		}else{
			customerComponent.updateCustomer(customer);
			TypeCusQB tqb = new TypeCusQB();
			tqb.setCusId(cusId);
			List<TypeCus> tcs = typeCusComponent.getTypeCuss(tqb);
			if(tcs!=null&&tcs.size()>0){
				for(int j=0;j<tcs.size();j++){
					typeCusComponent.removeTypeCus(tcs.get(j).getTypeCusId());
				}
			}
			int rw = cusImgsComponent.deleteByCusId(cusId);
		}
		if(cusImgs!=null){
			for(int i=0;i<cusImgs.size();i++){
				CusImgs cImg = cusImgs.get(i);
				if(cImg.getImgsAddr()==null||cImg.getImgsAddr().equals("")) continue;
				cImg.setCusId(cusId);
				cImg.setSts("A");
				cusImgsComponent.createCusImgs(cImg);
			}
		}
		if(scope!=null&&!scope.equals("")){
			String[] scopes = scope.split(",");
			for(int i=0,len=scopes.length;i<len;i++){
				TypeCus typeCus = new TypeCus();
				typeCus.setCusId(cusId);
				typeCus.setTcOrder(1L);
				typeCus.setTypesId(Long.parseLong(scopes[i]));
				typeCusComponent.createTypeCus(typeCus);
			}
		}
		return cusId;
	}

	@Override
	public Long findMaxPhone() {
		return customerComponent.findMaxPhone();
	}

	@Override
	public List<Customer> selectCols(CustomerQB queryBean) {
		return customerComponent.selectCols(queryBean);
	}

	@Override
	public PagingResultBean<List<Customer>> getCusInqPaging(PagingQueryBean<CustomerQB> pagingQueryBean) throws Exception {
		return customerComponent.getCusInqPaging(pagingQueryBean);
	}
}
