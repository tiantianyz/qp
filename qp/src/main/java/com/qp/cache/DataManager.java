package com.qp.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.cattsoft.baseplatform.cache.CacheAware;
import com.qp.entity.Customer;
import com.qp.entity.TypeImgs;
import com.qp.entity.Types;
import com.qp.service.CustomerService;
import com.qp.service.TypeImgsService;
import com.qp.service.TypesService;

public class DataManager implements InitializingBean, CacheAware {

	private static Logger log = Logger.getLogger(DataManager.class);
	private Cache cache;
	
	@Autowired
	private TypesService typesService;

	@Autowired
	private CustomerService customerService;
	@Override
	public void setCache(Cache cache) {
		this.cache = cache;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		List<Types> types = typesService.getAllTypess();
		Map<Long,String> tmap=new HashMap<Long,String>();
		if(types!=null){
			for(int i=0;i<types.size();i++){
				Types tone = types.get(i);
				tmap.put(tone.getTypesId(), tone.getTypesName());
			}
		}
		cache.put(new Element("tmap",tmap));
		cache.put(new Element("types",types));
	}
	public Object getValue(String key){
		Element data1 = cache.get(key);
		return data1 !=null ? data1.getValue():null;
	}

}
