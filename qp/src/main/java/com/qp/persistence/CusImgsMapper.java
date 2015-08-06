/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;

import com.cattsoft.baseplatform.core.entity.PagingQueryBean;
import com.qp.entity.CusImgs;
import com.qp.entity.querybean.CusImgsQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@MyBatisRepository
public interface CusImgsMapper {
	void insert(CusImgs cusImgs);

	int delete(Long cusImgId);

	void update(CusImgs cusImgs);

	CusImgs select(Long cusImgId);

	List<CusImgs> selectList(CusImgsQB queryBean);

	List<CusImgs> selectPage(PagingQueryBean<CusImgsQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<CusImgsQB> pagingQueryBean);

	Object proc(CusImgs cusImgs);
	
	int deleteByCusId(Long cusId);
	
}