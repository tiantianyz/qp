package com.qp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qp.bean.request.AdReqBean;
import com.qp.bean.request.GaragesReqBean;
import com.qp.bean.request.PageInfoReqBean;
import com.qp.bean.response.AdRspBean;
import com.qp.bean.response.BaseResponseBean;
import com.qp.bean.response.GaragesRspBean;
import com.qp.constant.CommConstant;
import com.qp.entity.AdminDivision;
import com.qp.entity.Garages;
import com.qp.entity.PagingInfo;
import com.qp.entity.PagingQueryBean;
import com.qp.entity.PagingResultBean;
import com.qp.entity.querybean.AdminDivisionQB;
import com.qp.entity.querybean.GaragesQB;
import com.qp.service.AdminDivisionService;
import com.qp.service.GaragesService;
@RequestMapping(value = "/garage")
@Controller
public class GarageController {
	
	private Logger logger = LoggerFactory.getLogger(GarageController.class);
	
	@Autowired
	private GaragesService garagesService;
	
	@Autowired
	private AdminDivisionService adminDivisionService;
	
	@RequestMapping(value = "/create.html")
	@ResponseBody
	public BaseResponseBean create(GaragesReqBean reqBean ,HttpServletRequest request){
		GaragesRspBean rspBean = new GaragesRspBean();
		try {
			if(reqBean.getGarageName()!=null&&!reqBean.getGarageName().equals("")){
				Garages garages = new Garages();
				if(reqBean.getGarageId()!=null) garages.setGarageId(reqBean.getGarageId());
				garages.setGarageName(reqBean.getGarageName());
				garages.setGaragePhone(reqBean.getGaragePhone());
				garages.setGarageImg(reqBean.getGarageImg());
				garages.setAreaId(reqBean.getAreaId());
				garages.setCreateDate(new Date());
				garagesService.createGarages(garages);
				rspBean.setGarageId(garages.getGarageId());
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/query.html")
	@ResponseBody
	public BaseResponseBean query(GaragesReqBean reqBean ,HttpServletRequest request){
		GaragesRspBean rspBean = new GaragesRspBean();
		try {
			PagingQueryBean<GaragesQB> qpBean = new PagingQueryBean<GaragesQB>();
			GaragesQB tqb = new GaragesQB();
			tqb.setAreaId(reqBean.getAreaId());
			tqb.setGarageId(reqBean.getGarageId());
			tqb.setGarageName(reqBean.getGarageName());
			qpBean.setQueryBean(tqb);
			PageInfoReqBean pageInfoReq = reqBean.getPageInfo();
			PagingInfo pageInfo = new PagingInfo();
			pageInfo.setPageNum(pageInfoReq!=null&&pageInfoReq.getCurrentPage()!=null?pageInfoReq.getCurrentPage():1);
			pageInfo.setPageRows(pageInfoReq!=null&&pageInfoReq.getPageNum()!=null?pageInfoReq.getPageNum():10);
			qpBean.setPagingInfo(pageInfo);
			PagingResultBean<List<Garages>> gas = garagesService.getGarageW(qpBean);
			rspBean.setGarage(gas.getResultList());
			rspBean.setPageInfo(pageInfo);
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/queryO.html")
	@ResponseBody
	public BaseResponseBean queryOne(GaragesReqBean reqBean ,HttpServletRequest request){
		GaragesRspBean rspBean = new GaragesRspBean();
		try {
			if(reqBean.getGarageId()!=null){
				Garages  one =garagesService.getGarages(reqBean.getGarageId());
				if(one!=null){
					rspBean.setAreaId(one.getAreaId());
					rspBean.setCreateDate(one.getCreateDate());
					rspBean.setGarageId(one.getGarageId());
					rspBean.setGarageImg(one.getGarageImg());
					rspBean.setGarageName(one.getGarageName());
					rspBean.setGaragePhone(one.getGaragePhone());
				}
			}
			
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
		return rspBean;
	}
	@RequestMapping(value = "/queryAone.html")
	@ResponseBody
	public BaseResponseBean queryAone(AdReqBean reqBean ,HttpServletRequest request,HttpServletResponse response){
		AdRspBean rspBean = new AdRspBean();
		try {
			AdminDivisionQB aqb = new AdminDivisionQB();
			if(reqBean.getDivisionId()==null) reqBean.setDivisionId(0L);
			aqb.setDivisionPid(reqBean.getDivisionId());
			List<AdminDivision> ads = adminDivisionService.getAdminDivisions(aqb);
			rspBean.setAds(ads);
		} catch (Exception e) {
			e.printStackTrace();
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			return rspBean;
		}
		return rspBean;
	}
}
