package com.qp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qp.bean.request.TypeImgsReqBean;
import com.qp.bean.request.TypesReqBean;
import com.qp.bean.response.BaseResponseBean;
import com.qp.bean.response.TypesRspBean;
import com.qp.cache.DataManager;
import com.qp.constant.CommConstant;
import com.qp.entity.Customer;
import com.qp.entity.TypeCus;
import com.qp.entity.TypeImgs;
import com.qp.entity.Types;
import com.qp.entity.TypesC;
import com.qp.entity.querybean.TypeCusQB;
import com.qp.entity.querybean.TypeImgsQB;
import com.qp.entity.querybean.TypesQB;
import com.qp.service.CustomerService;
import com.qp.service.TypeCusService;
import com.qp.service.TypeImgsService;
import com.qp.service.TypesService;
@RequestMapping(value = "/type")
@Controller
public class TypeController {
	
	private Logger logger = LoggerFactory.getLogger(TypeController.class);
	
	@Autowired
	private TypesService typesService;
	@Autowired
	private TypeImgsService typeImgsService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TypeCusService typeCusService;
	@Autowired
	private DataManager dataManager;
	
	@RequestMapping(value = "/query.html")
	@ResponseBody
	public BaseResponseBean queryT(TypesReqBean reqBean ,HttpServletRequest request,HttpServletResponse response){
		TypesRspBean rspBean = new TypesRspBean();
		try {
			TypesQB typesQB = new TypesQB();
			if(reqBean.getTypesPid()==null) reqBean.setTypesPid(0L);
			typesQB.setTypesPid(reqBean.getTypesPid());
			rspBean.setTypeId(reqBean.getTypesPid());
			List<Types> typeses = typesService.getTypess(typesQB);
			if(typeses==null||typeses.size()<=0){
				rspBean.setMessageCode(CommConstant.REDRICT_CODE);
				rspBean.setDescription(request.getContextPath()+"/pages/mlist.jsp?typesId="+reqBean.getTypesPid());
				return rspBean;
			}
			List<Types> childT = null;
			List<TypesC> data = new ArrayList<TypesC>();
			Types one = null;
			TypesC oneC = null;
			Long times = 0l;
			for(int i=0;i<typeses.size();i++){
				times = 0l;
				one=typeses.get(i);
				oneC = new TypesC();
				typesQB.setTypesPid(one.getTypesId());
				childT = typesService.getTypess(typesQB);
				oneC.setChildren(childT);
				if(childT!=null&&childT.size()>0){
					for(int m=0;m<childT.size();m++){
						times +=childT.get(m).getTypesTimes();
					}
				}
				one.setTypesTimes(times);
				oneC.setTypes(one);
				data.add(oneC);
			}
			TypeImgsQB imgQB = new TypeImgsQB();
			imgQB.setTypeId(reqBean.getTypesPid());
			List<TypeImgs> typeImgs = typeImgsService.getTypeImgss(imgQB);
			if(typeImgs!=null&&typeImgs.size()>0){
				Customer cus = null;
				for(int j=0;j<typeImgs.size();j++){
					TypeImgs timg = typeImgs.get(j);
					if(timg.getCusId()!=null){
						cus = customerService.getCustomer(timg.getCusId());
						if(cus!=null) timg.setPhone(cus.getCusPhone());
					}
				}
			}
			rspBean.setTypeImgs(typeImgs);
			Map<Long,String> tmap = (Map<Long,String>)dataManager.getValue("tmap");
			rspBean.setTypeName(tmap.get(rspBean.getTypeId()));
			rspBean.setData(data);
		} catch (Exception e) {
			e.printStackTrace();
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			return rspBean;
		}
		return rspBean;
	}
	@RequestMapping(value = "/queryc.html")
	@ResponseBody
	public BaseResponseBean queryC(TypesReqBean reqBean ,HttpServletRequest request,HttpServletResponse response){
		TypesRspBean rspBean = new TypesRspBean();
		try {
			TypesQB typesQB = new TypesQB();
			if(reqBean.getTypesPid()==null) reqBean.setTypesPid(0L);
			typesQB.setTypesPid(reqBean.getTypesPid());
			List<Types> typeses = typesService.getTypess(typesQB);
			Types updateT = new Types();
			updateT.setTypesId(reqBean.getTypesPid());
			updateT.setTypesTimes(1L);
			typesService.updateTypes(updateT);
			if(typeses==null||typeses.size()<=0){
				rspBean.setMessageCode(CommConstant.REDRICT_CODE);
				rspBean.setDescription(request.getContextPath()+"/pages/mlist.jsp?typesId="+reqBean.getTypesPid());
			}
		} catch (Exception e) {
			e.printStackTrace();
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			return rspBean;
		}
		return rspBean;
	}
	@RequestMapping(value = "/queryTone.html")
	@ResponseBody
	public BaseResponseBean queryTone(TypesReqBean reqBean ,HttpServletRequest request,HttpServletResponse response){
		TypesRspBean rspBean = new TypesRspBean();
		try {
			TypesQB typesQB = new TypesQB();
			if(reqBean.getTypesPid()==null) reqBean.setTypesPid(0L);
			typesQB.setTypesPid(reqBean.getTypesPid());
			List<Types> typeses = typesService.getTypess(typesQB);
			rspBean.setOneData(typeses);
		} catch (Exception e) {
			e.printStackTrace();
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			return rspBean;
		}
		return rspBean;
	}
	@RequestMapping(value = "/queryAll.html")
	@ResponseBody
	public BaseResponseBean queryAll(){
		TypesRspBean rspBean = new TypesRspBean();
		try {
			List<Types> types = (List<Types>)dataManager.getValue("types");
			rspBean.setOneData(types);
		} catch (Exception e) {
			e.printStackTrace();
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			return rspBean;
		}
		return rspBean;
	}
	@RequestMapping(value = "/stickCus.html")
	@ResponseBody
	public BaseResponseBean stickCus(TypesReqBean reqBean){
		TypesRspBean rspBean = new TypesRspBean();
		try {
			if(reqBean.getTypesId()==null||reqBean.getCusId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}
			TypeCusQB tqb = new TypeCusQB();
			tqb.setCusId(reqBean.getCusId());
			tqb.setTypesId(reqBean.getTypesId());
			List<TypeCus> tcs = typeCusService.getTypeCuss(tqb);
			if(tcs!=null&&tcs.size()>0){
				TypeCus tone = tcs.get(0);
				Long maxOrder = typeCusService.getMaxOrder(reqBean.getTypesId());
				tone.setTcOrder(maxOrder+1);
				typeCusService.updateTypeCus(tone);
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			return rspBean;
		}
		return rspBean;
	}
	@RequestMapping(value = "/getTimgs.html")
	@ResponseBody
	public BaseResponseBean getTimgs(TypesReqBean reqBean){
		TypesRspBean rspBean = new TypesRspBean();
		try {
			if(reqBean.getTypesId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
				return rspBean;
			}
			TypeImgsQB tiqb = new TypeImgsQB();
			tiqb.setTypeId(reqBean.getTypesId());
			List<TypeImgs> timgs = typeImgsService.getTypeImgss(tiqb);
			if(timgs!=null&&timgs.size()>0){
				for(int i=0,len=timgs.size();i<len;i++){
					if(timgs.get(i).getCusId()!=null){
						TypeImgs tone = timgs.get(i);
						Customer cone = customerService.getCustomer(tone.getCusId());
						tone.setCusName(cone.getCusName());
					}
				}
			}
			rspBean.setTypeImgs(timgs);
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			return rspBean;
		}
		return rspBean;
	}
	@RequestMapping(value = "/timgsC.html")
	@ResponseBody
	public BaseResponseBean timgsC(TypeImgsReqBean reqBean){
		TypesRspBean rspBean = new TypesRspBean();
		try {
			if(reqBean.getTypeId()==null||reqBean.getCusId()==null||
					reqBean.getTypeImgAddr()==null||reqBean.getTypeImgAddr().equals("")){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
				return rspBean;
			}
			TypeImgs tone = new TypeImgs();
			tone.setCusId(reqBean.getCusId());
			tone.setCusName(reqBean.getCusName());
			tone.setTypeId(reqBean.getTypeId());
			tone.setTypeImgAddr(reqBean.getTypeImgAddr());
			tone.setTypeImgId(reqBean.getTypeImgId());
			if(reqBean.getTypeImgId()==null){
				typeImgsService.createTypeImgs(tone);
			}else{
				typeImgsService.updateTypeImgs(tone);
			}
			
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			return rspBean;
		}
		return rspBean;
	}
	
}
