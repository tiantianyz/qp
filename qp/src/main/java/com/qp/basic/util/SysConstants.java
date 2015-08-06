package com.qp.basic.util;


/**
 * 系统常量。
 * 
 * @author ls
 */
public class SysConstants {
	
	public static final Double[] MIDDLE_SIZE_ARR = { Double.valueOf(1000), Double.valueOf(1000) };

	
	public static final Integer[] MIDDLE_SIZE_ARR_INT = {1000,1000};
	/**
	 * HTTP文件服务器配置常量
	 * @author ls
	 */
	public class FileSysConfig {
	    /**
         * 文件系统配置读取
         */
        public static final String FILESYS_CONFIG = "config/fileSys-config.properties";
        
        /**
         * FTP服务器地址
         */
        public static final String FTP_SERVER = "FTP_SERVER";
        
        /**
         * FTP服务器端口
         */
        public static final String FTP_PORT = "FTP_PORT";
        
        /**
         * FTP服务器用户名
         */
        public static final String FTP_USERNAME = "FTP_USERNAME";
        
        /**
         * FTP服务器密码
         */
        public static final String FTP_PASSWORD = "FTP_PASSWORD";
	    
		/**
		 * HTTP文件服务器Root URL
		 */
		public static final String HTTP_FILE_SYS_BASE_URL = "HTTP_FILE_SYS_BASE_URL";
		
//		# 默认上传根路径
		public static final String FTP_ROOT = "ftp_root";

//		#供应商
		public static final String FTP_SUPPLIER_LOGO = "ftp_supplier_logo";
		public static final String FTP_SUPPLIER_LICENSE = "ftp_supplier_license";
		public static final String FTP_SUPPLIER_TERMS = "ftp_supplier_terms";
		public static final String FTP_SUPPLIER_INSURANCE = "ftp_supplier_insurance";

//		#用户
		public static final String FTP_USER_ICON = "ftp_user_icon";

//		#产品
		public static final String FTP_PRODUCT_LOGO = "ftp_product_logo";
		public static final String FTP_PRODUCT_IMAGE = "ftp_product_image";
		public static final String FTP_PRODUCT_TRIP = "ftp_product_trip";
		public static final String FTP_PRODUCT_MENU = "ftp_product_menu";

//		#攻略
		public static final String FTP_STRATEGY_IMAGE = "ftp_strategy_image";

//		#标签
		public static final String FTP_LABEL_IMAGE = "ftp_label_image";

//		#广告图
		public static final String FTP_BANNER = "ftp_banner";

//		#季节促销活动图
		public static final String FTP_PROMOTION_IMAGE  = "ftp_promotion_image";
		//临时文件目录
		public static final String FTP_TEMPFILE = "ftp_temp_dir";
		
	}
}
