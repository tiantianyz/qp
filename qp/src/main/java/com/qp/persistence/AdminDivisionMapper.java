/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.qp.entity.AdminDivision;
import com.qp.entity.querybean.AdminDivisionQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@MyBatisRepository
public interface AdminDivisionMapper {
	void insert(AdminDivision adminDivision);

	void delete(Long divisionId);

	void update(AdminDivision adminDivision);

	AdminDivision select(Long divisionId);

	List<AdminDivision> selectList(AdminDivisionQB queryBean);

	List<AdminDivision> selectPage(PagingQueryBean<AdminDivisionQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<AdminDivisionQB> pagingQueryBean);

	Object proc(AdminDivision adminDivision);
	
}