/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.TypeImgs;
import com.qp.entity.querybean.TypeImgsQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@MyBatisRepository
public interface TypeImgsMapper {
	void insert(TypeImgs typeImgs);

	void delete(Long typeImgId);

	void update(TypeImgs typeImgs);

	TypeImgs select(Long typeImgId);

	List<TypeImgs> selectList(TypeImgsQB queryBean);

	List<TypeImgs> selectPage(PagingQueryBean<TypeImgsQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<TypeImgsQB> pagingQueryBean);

	Object proc(TypeImgs typeImgs);
	
}