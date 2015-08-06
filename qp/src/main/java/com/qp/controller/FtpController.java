package com.qp.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cattsoft.baseplatform.ui.pub.JsonUtils;
import com.qp.basic.util.ImageUtil;
import com.qp.basic.util.JsonUtil;
import com.qp.basic.util.PropertyUtil;
import com.qp.basic.util.SysConstants;
import com.qp.bean.request.ImageDeleteReqBean;
import com.qp.bean.response.BaseResponseBean;
import com.qp.bean.response.ImageUploadRspBean;
import com.qp.constant.CommConstant;


@RequestMapping(value = "/ftpOper")
@Controller
public class FtpController {

    /**
    * description: 上传图片
    *@param request
    *@param model
    *@return
    *@autor:Ding Chengyun
    *@createDate:2014-12-7
    */
    @RequestMapping(value = "upload.html", method=RequestMethod.POST) 
    public void upload(HttpServletRequest request,ModelMap model, HttpServletResponse response) {  
    	ImageUploadRspBean rspBean = new ImageUploadRspBean();
    	 try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			/** 页面控件的文件流 **/
			MultipartFile multipartFile = multipartRequest.getFile("file");
			String typeStr = multipartRequest.getParameter("type");
			Integer type;
			String filePath="base";
			if (StringUtils.isEmpty(typeStr)) {
				rspBean.setMessageCode(CommConstant.ERROR_CODE_PARAM_LOST);
				response.getOutputStream().write(JsonUtils.toJsonString(rspBean).getBytes());
				return;
			} else {
				type = Integer.valueOf(typeStr);
				switch(type){
					case 1:{
						filePath = "ad";
						break;
					}
					case 2:{
						filePath = "md";
						break;
					}
					case 3:{
						filePath = "ga";
						break;
					}
					case 4:{
						filePath = "ch";
						break;
					}
				}
			}
			
			
			/** 获取文件的后缀 **/
			String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			// /**使用UUID生成文件名称**/
			String imageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
			String imageUrl = filePath + imageName;// 构建文件名称

			InputStream in = multipartFile.getInputStream();
			ImageUtil.compressPicStream(in, 480, 800, imageName,filePath);
			rspBean.setImageUrl("/ftp/"+filePath +"/"+imageName);
		} catch (Exception e) {
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			e.printStackTrace();
		}
    	 response.setContentType("text/html");
    	 response.setCharacterEncoding("utf-8");
    	 try {
			response.getOutputStream().write(JsonUtil.getInstance().toJson(rspBean).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }  

    /**
    * description: 删除图片
    *@param requestBean
    *@return
    *@autor:Ding Chengyun
    *@createDate:2014-12-18
    */
    @RequestMapping(value = "delete.html")
    @ResponseBody
    public BaseResponseBean deleteImage(ImageDeleteReqBean requestBean) {
    	BaseResponseBean rspBean = new BaseResponseBean();
		try {
			Properties prop = PropertyUtil.getConfig(SysConstants.FileSysConfig.FILESYS_CONFIG);
			String rootUrl = prop.getProperty(SysConstants.FileSysConfig.HTTP_FILE_SYS_BASE_URL);
			String path = requestBean.getImageUrl().replace(rootUrl+"/ftp/", "");
			path =prop.getProperty(SysConstants.FileSysConfig.FTP_ROOT)+path;
			File file = new File(path);
			if(file.exists())
				file.delete();
		} catch (Exception e) {
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
		}
    	return rspBean;
    }
}
