package com.qp.constant;
/**
 * common 常量实体
* @ClassName: CommConstant 
* @Description:
* @author ls
* @date 2014-11-24 上午11:49:00
 */
public class CommConstant {
	
	/**
	 * 字符串分隔符
	 */
	public static final String SPLIT_LINE = "|";
	
	/**=========接口返回错误信息共5位，前两位是模块代码标号 后面是具体错误编号*/
	/**=========公共错误信息 30开头  后面跟三位数字*/
	/**
	 * 平台错误信息  内部错误
	 */
	public static final String ERROR_CODE_PLAT_ERROR = "30001";
	public static final String ERROR_DESC_PLAT_ERROR = "平台内部错误";
	
	/**
	 * 重定向
	 */
	public static final String REDRICT_CODE = "20010";
	public static final String REDRICT_DESC = "";
	
	/**
	 * 平台错误信息  参数缺失
	 */
	public static final String ERROR_CODE_PARAM_LOST = "30002";
	public static final String ERROR_DESC_PARAM_LOST = "参数缺失";
	/**
	 * 平台错误信息  参数缺失
	 */
	public static final String ERROR_CODE_PARAM_VALUE_LOST = "30003";
	public static final String ERROR_DESC_PARAM_VALUE_LOST = "参数值缺失";
	/**
	 * 平台错误信息  未查找到指定结果集
	 */
	public static final String ERROR_CODE_RESULT_LOST = "30004";
	public static final String ERROR_DESC_RESULT_LOST = "未查找到指定结果集";
	
	 /**
     * 平台错误信息  参数超出长度限制
     */
    public static final String ERROR_CODE_PARAM_OVER_LENGTH = "30005";
    public static final String ERROR_DESC_PARAM_OVER_LENGTH = "参数超出长度限制";
    
    /**
     * 平台错误信息  参数不合法
     */
    public static final String ERROR_CODE_PARAM_VALUE_INVALID = "30006";
    public static final String ERROR_DESC_PARAM_VALUE_INVALID = "参数不合法";
	
	/**=========首页错误信息 41开头 */
	
	/**=========用户错误信息 42开头 */
	/**
     * 用户错误信息  用户名称不能为空
     */
	public static final String ERROR_CODE_USER_USERNAME_MISS = "42001";
	public static final String ERROR_DESC_USER_USERNAME_MISS = "用户名称不能为空";
	/**
     * 用户错误信息  用户名称已存在
     */
	public static final String ERROR_CODE_USER_USERNAME_EXIST = "42002"; 
	public static final String ERROR_DESC_USER_USERNAME_EXIST = "用户名称已存在";
	/**
     * 用户错误信息  登陆邮箱不能为空
     */
	public static final String ERROR_CODE_USER_EMAIL_MISS = "42003"; 
	public static final String ERROR_DESC_USER_EMAIL_MISS = "登陆邮箱不能为空";
	/**
     * 用户错误信息  登陆邮箱已存在
     */
	public static final String ERROR_CODE_USER_EMAIL_EXIST = "42004"; 
	public static final String ERROR_DESC_USER_EMAIL_EXIST = "登陆邮箱已存在";
	/**
     * 用户错误信息  登陆邮箱邮箱格式不正确
     */
	public static final String ERROR_CODE_USER_EMAIL_ERROR = "42005"; 
	public static final String ERROR_DESC_USER_EMAIL_ERROR = "登陆邮箱邮箱格式不正确";
	/**
     * 用户错误信息  密码不能为空
     */
    public static final String ERROR_CODE_USER_PASSWORD_MISS = "42006";
	public static final String ERROR_DESC_USER_PASSWORD_MISS = "密码不能为空";
	/**
     * 用户错误信息  密码输入错误
     */
    public static final String ERROR_CODE_USER_PASSWORD_ERROR = "42007";
	public static final String ERROR_DESC_USER_PASSWORD_ERROR = "密码输入错误";
	/**
     * 用户错误信息  旧密码输入错误
     */
    public static final String ERROR_CODE_USER_PASSWORD_OLD_ERROR = "42008";
	public static final String ERROR_DESC_USER_PASSWORD_OLD_ERROR = "旧密码输入错误";
	/**
     * 用户错误信息  验证码不能为空
     */
    public static final String ERROR_CODE_USER_AUTHCODE_MISS = "42009";
	public static final String ERROR_DESC_USER_AUTHCODE_MISS = "验证码不能为空";
	/**
     * 用户错误信息  验证码输入错误
     */
    public static final String ERROR_CODE_USER_AUTHCODE_ERROR = "42010"; 
	public static final String ERROR_DESC_USER_AUTHCODE_ERROR = "验证码输入错误";
	/**
     * 用户错误信息  用户ID不能为空
     */
    public static final String ERROR_CODE_USER_ID_NOT_NULL_ERROR = "42011";
	public static final String ERROR_DESC_USER_ID_NOT_NULL_ERROR = "用户ID不能为空";
	/**
     * 用户错误信息  验证邮箱类型不能为空
     */
    public static final String ERROR_CODE_USER_AUTHEMAIL_TYPE_MISS = "42012";
	public static final String ERROR_DESC_USER_AUTHEMAIL_TYPE_MISS = "验证邮箱类型不能为空";
	/**
     * 用户错误信息  验证邮箱类型参数错误
     */
    public static final String ERROR_CODE_USER_AUTHEMAIL_TYPE_ERROR = "42013";
	public static final String ERROR_DESC_USER_AUTHEMAIL_TYPE_ERROR = "验证邮箱类型参数错误";
	/**
     * 用户错误信息  验证邮箱sid不能为空
     */
    public static final String ERROR_CODE_USER_AUTHEMAIL_SIG_MISS = "42014";
	public static final String ERROR_DESC_USER_AUTHEMAIL_SIG_MISS = "验证邮箱sid不能为空";
	/**
	 * 用户错误信息 用户不存在
	 */
	public static final String ERROR_CODE_USER_NOT_EXIST = "42015";
	public static final String ERROR_DESC_USER_NOT_EXIST = "用户不存在";
	
	/**
     * 用户错误信息  用户未登录
     */
    public static final String ERROR_CODE_USER_NOT_LOGIN = "42016";
    public static final String ERROR_DESC_USER_NOT_LOGIN = "用户未登录";
    /**
     * 用户错误信息  登录邮箱超出长度限制
     */
    public static final String ERROR_CODE_LOGIN_EMAIL_OVER_LENGTH = "42017";
    public static final String ERROR_DESC_LOGIN_EMAIL_OVER_LENGTH = "登录邮箱超出长度限制";
    /**
     * 供应商错误信息   验证码失效
     */
    public static final String ERROR_CODE_SUPPLIER_AUTHCODE_INVALID = "42018"; 
   	public static final String ERROR_DESC_SUPPLIER_AUTHCODE_INVALID = "验证码失效";
   	/**
     * 验证邮箱错误信息  验证邮箱链接已失效
     */
    public static final String ERROR_CODE_AUTHEMAIL_OVER_TIME = "42019";
    public static final String ERROR_DESC_AUTHEMAIL_OVER_TIME = "验证邮箱链接已失效";
    /**
     * 供应商错误信息   验证码数据库中不存在
     */
    public static final String ERROR_CODE_SUPPLIER_AUTHCODE_NOT_IN_DB = "42020"; 
    public static final String ERROR_DESC_SUPPLIER_AUTHCODE_NOT_IN_DB = "验证码数据库中不存在";
    
    /**
     * 供应商错误信息  供应商ID不能为空
     */
    public static final String ERROR_CODE_SUPPLIER_ID_NOT_NULL_ERROR = "42021";
    public static final String ERROR_DESC_SUPPLIER_ID_NOT_NULL_ERROR = "供应商ID不能为空";
    
    /**
     * 供应商错误信息  供应商ID不能为空
     */
    public static final String ERROR_CODE_SUPPLIER_ID_NOT_FOUND = "42022";
    public static final String ERROR_DESC_SUPPLIER_ID_NOT_FOUND = "供应商ID不存在";
    /**
     * 用户错误信息  用户收藏：该产品已收藏
     */
    public static final String ERROR_CODE_USER_COLLECTED = "42023";
    public static final String ERROR_DESC_USER_COLLECTED = "该产品已收藏";
    
	/**=========商户错误信息 43开头  */
    /**
     * 商户错误信息 商户合作条款信息不存在
     */
    public static final String ERROR_CODE_SUPPLIER_TERMS_NOT_EXIST = "43001";
    public static final String ERROR_DESC_SUPPLIER_TERMS_NOT_EXIST = "商户合作条款信息不存在";
    /**
     * 商户错误信息  商户未登录
     */
    public static final String ERROR_CODE_SUPPLIER_NOT_LOGIN = "43002";
    public static final String ERROR_DESC_SUPPLIER_NOT_LOGIN = "商户未登录";
    /**
     * 供应商确认合作条款 错误信息  审核状态不对 
     */
    public static final String ERROR_CODE_SUPPLIER_WRONG_VERIFYSTATUS = "43003";
    public static final String ERROR_DESC_SUPPLIER_WRONG_VERIFYSTATUS = "错误的供应商审核状态";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_SHOTNAME_NULL = "43004";
    public static final String ERROR_DESC_SUPPLIER_SHOTNAME_NULL = "公司简称不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_SHORTDESC_NULL = "43005";
    public static final String ERROR_DESC_SUPPLIER_SHORTDESC_NULL = "公司简介不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_LOGOURL_NULL = "43006";
    public static final String ERROR_DESC_SUPPLIER_LOGOURL_NULL = "公司LOGO不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_NAME_NULL = "43007";
    public static final String ERROR_DESC_SUPPLIER_NAME_NULL = "公司名称不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_REGISTNATION_NULL = "43008";
    public static final String ERROR_DESC_SUPPLIER_REGISTNATION_NULL = "注册国不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_REGISTCITY_NULL = "43009";
    public static final String ERROR_DESC_SUPPLIER_REGISTCITY_NULL = "所在城市不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_TIMEZONE_NULL = "43010";
    public static final String ERROR_DESC_SUPPLIER_TIMEZONE_NULL = "时区不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_REGISTADDRESS_NULL = "43011";
    public static final String ERROR_DESC_SUPPLIER_REGISTADDRESS_NULL = "详细地址不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_ZIPCODE_NULL = "43012";
    public static final String ERROR_DESC_SUPPLIER_ZIPCODE_NULL = "邮编不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_TELEPHONE_NULL = "43013";
    public static final String ERROR_DESC_SUPPLIER_TELEPHONE_NULL = "公司电话不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_EMAIL_NULL = "43014";
    public static final String ERROR_DESC_SUPPLIER_EMAIL_NULL = "公司邮箱不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_LICENSEURL_NULL = "43015";
    public static final String ERROR_DESC_SUPPLIER_LICENSEURL_NULL = "公司营业执照不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_INSURANCEURL_NULL = "43016";
    public static final String ERROR_DESC_SUPPLIER_INSURANCEURL_NULL = "公司产品保险政策不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_CONTACTNAME_NULL = "43017";
    public static final String ERROR_DESC_SUPPLIER_CONTACTNAME_NULL = "联系人姓名不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_CONTACTTEL_NULL = "43018";
    public static final String ERROR_DESC_SUPPLIER_CONTACTTEL_NULL = "联系人电话不能为空";
    /**
     * 供应商信息修改错误信息 
     */
    public static final String ERROR_CODE_SUPPLIER_CONTACTEMAIL_NULL = "43019";
    public static final String ERROR_DESC_SUPPLIER_CONTACTEMAIL_NULL = "联系人邮箱不能为空";
    
	/**=========产品错误信息 44开头  */
	/**
	 * 产品评论  错误信息  已经评论过
	 */
	public static final String ERROR_CODE_ADDCOMMENT_EXIST = "44010";
	public static final String ERROR_DESC_ADDCOMMENT_EXIST = "已经评论过";
	
	/**=========产品相关错误信息 45开头**/
	
	/**
	 * 产品id不存在
	 */
	public static final String ERROR_CODE_PRODID_NOT_EXIST = "45001";
	public static final String ERROR_DESC_PRODID_NOT_EXIST = "产品id不存在";
	
	/**=========攻略错误信息 44开头  */
	
	/**=========季节活动信息 44开头  */
	
	/**=========支付错误信息 48开头  */
	/**
     * 支付维护数据成功
     */
    public static final String PAY_SUCC_CODE = "48000";
    /**
     * 支付错误1 code 产品数量不足
     */
    public static final String PAY_ERROR_CODE_PRICE_NUM ="48001";
    /**
     * 支付错误 1  描述 产品数量不足
     */
    public static final String PAY_ERROR_DESC_PRICE_NUM ="产品数量不足";
    /**
     * 支付错误2  code 升级包数量不足
     */
    public static final String PAY_ERROR_CODE_UPGRADE_NUM = "48002";
    /**
     * 支付错误2  描述  升级包数量不足
     */
    public static final String PAY_ERROR_DESC_UPGRADE_NUM = "升级包数量不足";
    /**
     * 支付错误， 订单已经支付成功
     */
    public static final String PAY_ERROR_CODE_ORDER_PAYED = "48003";
    public static final String PAY_ERROR_DESC_ORDER_PAYED = "订单已经支付";
    /**
     * 订单修改状态错误   订单不存在
     */
    public static final String ORDER_ERROR_CODE_NOT_EXIST = "48004";
    public static final String ORDER_ERROR_DESC_NOT_EXIST = "订单不存在";
	/**
	 * 订单修改状态错误  订单状态不正确
	 */
    public static final String ORDER_ERROR_CODE_WRONG_STATUS = "48005";
    public static final String ORDER_ERROR_DESC_WORNG_STATUS = "订单状态不正确";
    /**
     * 订单错误  预定 时间格式不正确
     */
    public static final String ORDER_ERROR_CODE_WRONG_DATE = "48006";
    public static final String ORDER_ERROR_DESC_WRONG_DATE = "时间格式不正确";
    /**
     * 订单错误  产品已下架  
     */
    public static final String ORDER_ERROR_CODE_PROD_OFFSHELF = "48007";
    public static final String ORDER_ERROR_DESC_PROD_OFFSHELF = "产品已下架";
    
    /**
     * 订单错误  产品审核中
     */
    public static final String ORDER_ERROR_CODE_PROD_VERIFY = "48008";
    public static final String ORDER_ERROR_DESC_PROD_VERIFY = "产品审核中";
    
    /**
     * 订单错误  参数错误 没找到对应产品信息
     */
    public static final String ORDER_ERROR_CODE_PROD_NOTEXIST = "48009";
    public static final String ORDER_ERROR_DESC_PROD_NOTEXIST = "产品不存在";
    
	/**=========图片相关错误 46开头 */
	
	/**
	 * 图片上传失败
	 */
	public static final String ERROR_CODE_IMAGE_UPLOAD_FAIL = "46001";
	public static final String ERROR_DESC_IMAGE_UPLOAD_FAIL = "图片上传失败";
	/**
	 * 图片删除失败
	 */
	public static final String ERROR_CODE_IMAGE_DELETE_FAIL = "46002";
	public static final String ERROR_DESC_IMAGE_DELETE_FAIL = "图片删除失败";
	/**
	 * 订单编号前缀
	 */
	public static final String ORDER_CODE_PREFFIX = "WXWO";
	/**
	 * 产品编号前缀
	 */
	public static final String PRODUCT_CODE_PREFFIX = "WXWP";
	/**
	 * 记录使用状态  1  在用
	 */
	public static final Byte STATUS_USING_YES = 1;
	/**
	 * 记录使用状态 0 废弃
	 */
	public static final Byte STATUS_USING_NO = 0;
	
	/**
	 * 每页数量 10
	 */
	public static final Integer PAGE_NUM_TEN = 10;
	
	/**
	 * 每页数量 12
	 */
	public static final Integer PAGE_NUM_TWELVE = 12;
	
	/**
	 * 每页数量20
	 */
	public static final Integer PAGE_NUM_TWENTI = 20;
	/**
	 * 当前页默认值  1
	 */
	public static final Integer PAGE_CURRENT_ONE = 1;
	/**
	 * 问答接口默认状态类型
	 */
	public static final Byte CONSULT_LIST_TYPE_DEFAULT = 1;
	/**
	 * 热门信息 类型   0 咨询
	 */
	public static final Byte HOT_OBJECT_TYPE_CONSULT = 0;
	/**
	 * 热门信息 类型  1 评论
	 */
	public static final Byte HOT_OBJECT_TYPE_COMMENT = 1;
	/**
	 * 咨询回复状态    1
	 */
	public static final Byte CONSULT_STATUS_1 = 1;
	/**
	 * 区域级别 2级（区域）
	 */
	public static final Byte AREA_LEVEL_TWO = 2;
	/**
	 * 区域级别 3级（国家）
	 */
	public static final Byte AREA_LEVEL_THREE = 3;
	/**
     * 区域信息 城市级别：4
     */
    public static final Byte AREA_LEVEL_CITY = 4; 
    
    /**
     * 标签code：0 主题
     */
    public static final Byte LEBEL_INFO_CODE_0 = 0;
    /**
     * 标签code  1 首页攻略
     */
    public static final Byte LEBEL_INFO_CODE_1 = 1;
    /**
     * 标签code 热销榜
     */
    public static final Byte LEBEL_INFO_CODE_2 = 2;
    /**
     * 标签攻略关系表   标签下属为攻略
     */
    public static final Byte STRATEGY_REL_OBJECT_TYPE_1 = 1;
    /**
     * 标签攻略关系表  攻略下属为标签
     */
    public static final Byte STRATEGY_REL_OBJECT_TYPE_2 = 2;
     /**
     * 攻略级别 1级
     */
    public static final Byte STRATEGY_LEVEL_1 = 1;
    /**
     * 攻略级别 2级
     */
    public static final Byte STRATEGY_LEVEL_2 = 2;
    /**
     * 图片列表 类型  1攻略
     */
    public static final Byte PICTUREINFO_OBJECT_TYPE_1 = 1;
    /**
     * 图片列表 类型 2标签
     */
    public static final Byte PICTUREINFO_OBJECT_TYPE_2 = 2;
    /**
     * 图片列表 类型 3促销活动
     */
    public static final Byte PICTUREINFO_OBJECT_TYPE_3 = 3;
    /**
     * 攻略code 3  首页攻略列表code
     */
    public static final Byte LABEL_CODE_3 = 3;

}
