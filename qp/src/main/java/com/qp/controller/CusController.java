package com.qp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.util.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qp.bean.request.CusReqBean;
import com.qp.bean.request.PageInfoReqBean;
import com.qp.bean.response.BaseResponseBean;
import com.qp.bean.response.CusRspBean;
import com.qp.cache.DataManager;
import com.qp.constant.CommConstant;
import com.qp.entity.Collects;
import com.qp.entity.CusImgs;
import com.qp.entity.Customer;
import com.qp.entity.Laud;
import com.qp.entity.PagingInfo;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.TypeCus;
import com.qp.entity.TypeImgs;
import com.qp.entity.querybean.CollectsQB;
import com.qp.entity.querybean.CusImgsQB;
import com.qp.entity.querybean.CustomerQB;
import com.qp.entity.querybean.LaudQB;
import com.qp.entity.querybean.TypeCusQB;
import com.qp.entity.querybean.TypeImgsQB;
import com.qp.service.CollectsService;
import com.qp.service.CusImgsService;
import com.qp.service.CustomerService;
import com.qp.service.LaudService;
import com.qp.service.TypeCusService;
import com.qp.service.TypeImgsService;
import com.qp.service.TypesService;
@RequestMapping(value = "/customer")
@Controller
public class CusController {
	
	private Logger logger = LoggerFactory.getLogger(CusController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TypeImgsService typeImgsService;
	
	@Autowired
	private TypeCusService typeCusService;
	
	@Autowired
	private TypesService typesService;
	
	@Autowired
	private DataManager dataManager;
	
	@Autowired
	private CusImgsService cusImgsService;
	
	@Autowired
	private CollectsService collectsService;

	@Autowired
	private LaudService laudService;
	
	@RequestMapping(value = "/query.html")
	@ResponseBody
	public BaseResponseBean queryC(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		if(reqBean.getTypesId()!=null) rspBean.setType(reqBean.getTypesId().toString());
		try {
			PagingQueryBean<TypeCusQB> qpBean = new PagingQueryBean<TypeCusQB>();
			TypeCusQB tqb = new TypeCusQB();
			tqb.setTypesId(reqBean.getTypesId());
			tqb.setOpenId(reqBean.getOpenId());
			qpBean.setQueryBean(tqb);
			PageInfoReqBean pageInfoReq = reqBean.getPageInfo();
			PagingInfo pageInfo = new PagingInfo();
			pageInfo.setPageNum(pageInfoReq!=null&&pageInfoReq.getCurrentPage()!=null?pageInfoReq.getCurrentPage():1);
			pageInfo.setPageRows(pageInfoReq!=null&&pageInfoReq.getPageNum()!=null?pageInfoReq.getPageNum():10);
			qpBean.setPagingInfo(pageInfo);
			PagingResultBean<List<Customer>> cuses = typeCusService.queryComplex(qpBean);
			List<Customer> cusList = cuses.getResultList();
			if(cusList!=null&&cusList.size()>0){
				Map<Long,String> tmap = (Map<Long,String>)dataManager.getValue("tmap");
				TypeCusQB tcQb = new TypeCusQB();
				List<TypeCus> typecus = null;
				for(int j=0;j<cusList.size();j++){
					String cusIds ="";
					Customer cus = cusList.get(j);
					tcQb.setCusId(cus.getCusId());
					typecus = typeCusService.getTypeCuss(tcQb);
					if(typecus!=null){
						for(int m=0,len=typecus.size();m<len;m++){
							cusIds += tmap.get(typecus.get(m).getTypesId());
							if(m!=(len-1)) cusIds +=",";
						}
					}
					cus.setCusScope(cusIds);
				}
				rspBean.setData(cusList);
				rspBean.setValue(tmap.get(reqBean.getTypesId()));
			}
			if(pageInfo.getPageNum()==1&&reqBean.getTypesId()!=null){
				TypeImgsQB imgQB = new TypeImgsQB();
				imgQB.setTypeId(reqBean.getTypesId());
				List<TypeImgs> typeImgs = typeImgsService.getTypeImgss(imgQB);
				if(typeImgs!=null&&typeImgs.size()>0){
					Customer cusone = null;
					for(int j=0;j<typeImgs.size();j++){
						TypeImgs timg = typeImgs.get(j);
						if(timg.getCusId()!=null){
							cusone = customerService.getCustomer(timg.getCusId());
							if(cusone!=null) timg.setPhone(cusone.getCusPhone());
						}
					}
				}
				rspBean.setTypeImgs(typeImgs);
				
			}
			rspBean.setPageInfo(pageInfo);
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/updateT.html")
	@ResponseBody
	public BaseResponseBean updateT(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getCusId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}else{
				Customer updateC = new Customer();
				updateC.setCusId(reqBean.getCusId());
				updateC.setCusTimes(1L);
				customerService.updateCustomer(updateC);
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/createOne.html")
	@ResponseBody
	public BaseResponseBean createOne(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getCusName()==null||reqBean.getCusName().equals("")){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}else{
				Customer createone = new Customer();
				createone.setCusId(reqBean.getCusId());
				createone.setCusAddr(reqBean.getCusAddr());
				createone.setCusDate(new Date());
				createone.setCusName(reqBean.getCusName());
				createone.setCusOrder(reqBean.getCusOrder());
				createone.setCusPhone(reqBean.getCusPhone());
				createone.setCusPhone1(reqBean.getCusPhone1());
				createone.setCusPhone2(reqBean.getCusPhone2());
				createone.setCusRemark(reqBean.getCusRemark());
				createone.setCusSite(reqBean.getCusSite());
				createone.setCusTimes(0L);
				createone.setCusHeadImg(reqBean.getCusHeadImg());
				createone.setCusScope(reqBean.getCusScope());
				createone.setCusDesc(reqBean.getCusDesc());
				List<Customer> cuss = null;
				if(createone.getCusId()==null){
					CustomerQB cusQB = new CustomerQB();
					cusQB.setCusName(reqBean.getCusName());
					cuss = customerService.getCustomers(cusQB);
				}
				if(cuss!=null&&cuss.size()>0){
					rspBean.setMessageCode(CommConstant.ERROR_CODE_USER_USERNAME_EXIST);
					rspBean.setDescription("商户名字不存在");
				}else{
					customerService.createOne(createone,reqBean.getCusImgs());
				}
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/findMaxPhone.html")
	@ResponseBody
	public BaseResponseBean findMaxPhone(HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			Long maxphone = customerService.findMaxPhone();
			if(maxphone!=null) maxphone +=1;
				
			rspBean.setPhone(maxphone);
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/queryOne.html")
	@ResponseBody
	public BaseResponseBean queryOne(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getCusId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}else{
				Customer cus = customerService.getCustomer(reqBean.getCusId());
				String openId = (String) request.getSession().getAttribute("openId");
				if(openId!=null&&!openId.equals("")){
					CollectsQB cqb = new CollectsQB();
					cqb.setCusId(cus.getCusId());
					cqb.setOpenId(openId);
					List<Collects> colss = collectsService.getCollectss(cqb);
					if(colss!=null&&colss.size()>0) rspBean.setIsCol(1);
					LaudQB lqb = new LaudQB();
					lqb.setCusId(cus.getCusId());
					lqb.setOpenId(openId);
					List<Laud> lauds = laudService.getLauds(lqb);
					if(lauds!=null&&lauds.size()>0) rspBean.setIsLaud(1);
				}
				if(reqBean.getCusTimes()==null&&cus.getCusRemark()!=null&&!cus.getCusRemark().equals("")){
					cus.setCusScope(cus.getCusRemark());
				}else{
					Map<Long,String> tmap = (Map<Long,String>)dataManager.getValue("tmap");
					TypeCusQB tqb = new TypeCusQB();
					tqb.setCusId(reqBean.getCusId());
					List<TypeCus> tcs = typeCusService.getTypeCuss(tqb);
					StringBuffer scope = new StringBuffer();
					StringBuffer scopeIds = new StringBuffer();
					String sp = ",";
					if(tcs!=null&&tcs.size()>0){
						for(int i=0,len=tcs.size();i<len;i++){
							TypeCus tone = tcs.get(i);
							scope.append(tmap.get(tone.getTypesId()));
							scope.append(sp);
							scopeIds.append(tone.getTypesId());
							scopeIds.append(sp);
						}
						scope.deleteCharAt(scope.length()-1);
						scopeIds.deleteCharAt(scopeIds.length()-1);
					}
					cus.setCusScope(scope.substring(0));
					rspBean.setType(scopeIds.substring(0));
				}
				CusImgsQB imgQB = new CusImgsQB();
				imgQB.setCusId(reqBean.getCusId());
				List<CusImgs> imgLists = cusImgsService.getCusImgss(imgQB);
				List<CusImgs> outImgs = new ArrayList<CusImgs>();
				if(imgLists!=null&&reqBean.getTypesId()!=null){
					for(int i=0,len=imgLists.size();i<len;i++){
						if(imgLists.get(i).getTypesId()==null||imgLists.get(i).getTypesId().compareTo(reqBean.getTypesId()) ==0)
							outImgs.add(imgLists.get(i));
					}
				}else
					outImgs = imgLists;
				cus.setImgs(outImgs);
				rspBean.setCustomer(cus);
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/queryP.html")
	@ResponseBody
	public BaseResponseBean queryPage(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			CustomerQB cusQB = new CustomerQB();
			cusQB.setCusAddr(reqBean.getCusAddr());
			cusQB.setCusNamel(reqBean.getCusName());
			cusQB.setCusOrder(reqBean.getCusOrder());
			cusQB.setCusPhone(reqBean.getCusPhone());
			cusQB.setCusPhone1(reqBean.getCusPhone1());
			cusQB.setTypesId(reqBean.getTypesId());
			PagingQueryBean<CustomerQB> pgQB = new PagingQueryBean<>();
			PageInfoReqBean pageInfoReq = reqBean.getPageInfo();
			PagingInfo pageInfo = new PagingInfo();
			pageInfo.setPageNum(pageInfoReq!=null&&pageInfoReq.getCurrentPage()!=null?pageInfoReq.getCurrentPage():1);
			pageInfo.setPageRows(pageInfoReq!=null&&pageInfoReq.getPageNum()!=null?pageInfoReq.getPageNum():10);
			pgQB.setPagingInfo(pageInfo);
			pgQB.setQueryBean(cusQB);
			PagingResultBean<List<Customer>> result = customerService.getCusInqPaging(pgQB);
			rspBean.setData(result.getResultList());
			rspBean.setPageInfo(result.getPagingInfo());
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/colS.html")
	@ResponseBody
	public BaseResponseBean collectCus(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getCusId()==null||reqBean.getOpenId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}
			Collects colt = new Collects();
			colt.setCusId(reqBean.getCusId());
			colt.setOpenId(reqBean.getOpenId());
			collectsService.createCollects(colt);
		} catch (Exception e) {
			Log.info(e.getMessage());
		}
		return rspBean;
	}
	@RequestMapping(value = "/colR.html")
	@ResponseBody
	public BaseResponseBean colR(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getCusId()==null||reqBean.getOpenId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}
			Collects colt = new Collects();
			colt.setCusId(reqBean.getCusId());
			colt.setOpenId(reqBean.getOpenId());
			collectsService.removeCollects(colt);
		} catch (Exception e) {
			Log.info(e.getMessage());
		}
		return rspBean;
	}
	@RequestMapping(value = "/colM.html")
	@ResponseBody
	public BaseResponseBean cCuss(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getOpenId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}
			CustomerQB cQb = new CustomerQB();
			cQb.setCusId(reqBean.getCusId());
			cQb.setOpenId(reqBean.getOpenId());
			List<Customer> cuses = customerService.selectCols(cQb);
			rspBean.setData(cuses);
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/laudc.html")
	@ResponseBody
	public BaseResponseBean laudc(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getOpenId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}
			Laud laud = new Laud();
			laud.setCusId(reqBean.getCusId());
			laud.setOpenId(reqBean.getOpenId());
			laudService.createLaud(laud);
		} catch (Exception e) {
			Log.info(e.getMessage());
		}
		return rspBean;
	}
	@RequestMapping(value = "/laudr.html")
	@ResponseBody
	public BaseResponseBean laudr(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getOpenId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}
			Laud laud = new Laud();
			laud.setCusId(reqBean.getCusId());
			laud.setOpenId(reqBean.getOpenId());
			laudService.removeLaud(laud);
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/getUUid.html")
	@ResponseBody
	public BaseResponseBean getUUid(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getCusId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
			}
			UUID uuid = UUID.randomUUID();
			String uid = uuid.toString();
			Customer ud = new Customer();
			ud.setCusId(reqBean.getCusId());
			customerService.updateCustomer(ud);
			rspBean.setCustomer(ud);
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/deleteCus.html")
	@ResponseBody
	public BaseResponseBean deleteCus(CusReqBean reqBean ,HttpServletRequest request){
		CusRspBean rspBean = new CusRspBean();
		try {
			if(reqBean.getCusId()==null){
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				rspBean.setDescription(CommConstant.ERROR_DESC_PARAM_LOST);
				return rspBean;
			}
			customerService.removeCustomer(reqBean.getCusId());
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	
}
