package com.qp.basic.util;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * 配置地址工具类
 * 
 * @ClassName: SysConstUtil
 * @Description:
 * @author ls
 * @date 2014-12-17 下午4:55:45
 */
public class SysConstUtil {

	public static String HTTP_FILE_SYS_BASE_URL = "";

	public static String TEMP_FILE = "";
	
	private static Properties prop = null;

	static {
		prop = PropertyUtil.getConfig(SysConstants.FileSysConfig.FILESYS_CONFIG);
		HTTP_FILE_SYS_BASE_URL = prop
				.getProperty(SysConstants.FileSysConfig.HTTP_FILE_SYS_BASE_URL);
		TEMP_FILE = prop.getProperty(SysConstants.FileSysConfig.FTP_TEMPFILE);
	}

	/**
	 * 相对地址替换成绝对地址
	 * @Title: covertToRealUrl
	 * @param relativeUrl
	 * @return String
	 * @author ls
	 */
	public static String covertToRealUrl(String relativeUrl) {
		if(StringUtils.isNotBlank(relativeUrl)){
			relativeUrl =  HTTP_FILE_SYS_BASE_URL + relativeUrl;
		}
		return relativeUrl;
	}
	/**
	 * 绝对地址替换成相对地址
	* @Title: covertToRelativeUrl 
	* @param realUrl
	* @return
	* @author ls
	 */
	public static String covertToRelativeUrl(String realUrl) {
	    if (StringUtils.isBlank(realUrl)) {
            return "";
        }
		return realUrl.replace(HTTP_FILE_SYS_BASE_URL, "");
	}
	/**
	 * 获取上传路径
	* @Title: getFilePath 
	* @param type
	* @param subType
	* @return
	* @author ls
	 */
	public static String getFilePath(Integer type, Integer subType) {
    	String filePath = "";
    	switch (type) {
		case 10 : { // 供应商
			switch (subType) { // logo
			case 101 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_SUPPLIER_LOGO));
				break;
			}
			case 102 : { // 营业执照
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_SUPPLIER_LICENSE));
				break;
			}
			case 103 : { // 合同条款
			    filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_SUPPLIER_TERMS));
			    break;
			}
			case 104 : { // 合同保险
			    filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_SUPPLIER_INSURANCE));
			    break;
			}
			}
			break;
		}
		case 20 : { // 用户表
			switch (subType) {
			case 201 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_USER_ICON));
				break;
			}
			}
			break;
		}
		case 30 : { // 产品表
			switch (subType) {
			case 301 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_PRODUCT_LOGO));
				break;
			}
			case 302 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_PRODUCT_IMAGE));
				break;
			}
			case 303 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_PRODUCT_TRIP));
				break;
			}
			case 304 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_PRODUCT_MENU));
				break;
			}
			}
			
			break;
		}
		case 40 : { // 攻略
			switch (subType) {
			case 01 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_STRATEGY_IMAGE));
				break;
			}
			}
			break;
		}
		case 50 : { // 标签
			switch (subType) {
			case 01 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_LABEL_IMAGE));
				break;
			}
			}
			break;
		}
		case 60 : { // 广告图
			switch (subType) {
			case 01 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_BANNER));
				break;
			}
			}
			break;
		}
		case 70 : { // 季节促销活动图
			switch (subType) { 
			case 701 : {
				filePath = prop.getProperty((SysConstants.FileSysConfig.FTP_PROMOTION_IMAGE));
				break;
			}
			}
			break;
		}
    	}
    	return filePath;
    }
}
