/*
 * Powered By Generator Util
 */

package com.qp.persistence;
import java.util.List;

import com.cattsoft.xhrd.core.persistence.mybatis.annotation.MyBatisRepository;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.TypeCus;
import com.qp.entity.Types;
import com.qp.entity.querybean.TypesQB;
/**
 * 
 * Description: <br>
 * Date: <br>
 * Copyright (c) 2012 CATTSoft <br>
 * 
 * @author CHASE
 */
@MyBatisRepository
public interface TypesMapper {
	void insert(Types types);

	void delete(Long typesId);

	void update(Types types);

	Types select(Long typesId);

	List<Types> selectList(TypesQB queryBean);

	List<Types> selectPage(PagingQueryBean<TypesQB> pagingQueryBean);

	Integer selectCount(PagingQueryBean<TypesQB> pagingQueryBean);

	Object proc(Types types);
	
	List<TypeCus> selectComplex(PagingQueryBean<TypesQB> pagingQueryBean);
	
	Integer selectComplexCount(PagingQueryBean<TypesQB> pagingQueryBean);
	
	
	
}