/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.qp.entity.Laud;
import com.qp.entity.querybean.LaudQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@MyBatisRepository
public interface LaudMapper {
	void insert(Laud laud);

	void delete(Laud laud);

	void update(Laud laud);

	Laud select(Long openId);

	List<Laud> selectList(LaudQB queryBean);

	List<Laud> selectPage(PagingQueryBean<LaudQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<LaudQB> pagingQueryBean);

	Object proc(Laud laud);
	
}