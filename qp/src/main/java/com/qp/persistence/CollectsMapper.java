/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.qp.entity.Collects;
import com.qp.entity.querybean.CollectsQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@MyBatisRepository
public interface CollectsMapper {
	void insert(Collects collects);

	void delete(Collects collects);

	void update(Collects collects);

	Collects select(Long openId);

	List<Collects> selectList(CollectsQB queryBean);

	List<Collects> selectPage(PagingQueryBean<CollectsQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<CollectsQB> pagingQueryBean);

	Object proc(Collects collects);
	
}