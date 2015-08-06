/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;
import com.qp.entity.Garages;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.querybean.GaragesQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@MyBatisRepository
public interface GaragesMapper {
	void insert(Garages garages);

	void delete(Long garageId);

	void update(Garages garages);

	Garages select(Long garageId);

	List<Garages> selectList(GaragesQB queryBean);

	List<Garages> selectPage(PagingQueryBean<GaragesQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<GaragesQB> pagingQueryBean);

	Object proc(Garages garages);
	
	List<Garages> selectWPage(PagingQueryBean<GaragesQB> pagingQueryBean);
}