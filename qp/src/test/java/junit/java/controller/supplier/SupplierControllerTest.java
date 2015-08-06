package junit.java.controller.supplier;

import junit.java.controller.BaseControllerTest;

import org.junit.Before;
import org.junit.Test;

public class SupplierControllerTest extends BaseControllerTest {

	@Before
	public void init() {
		localhostBaseUrl = "http://localhost:8080/wxw_web/";
	}
	
	/**
	 * 获取供应商收款账户信息
	* @Title: accountInfo 
	* @author ls
	 */
	@Test
	public void accountInfo() {
		String json = getJsonFromFile("/junit/json/supplier/accountInfo.json");
		this.sendPostReqOfLocalhost(null, localhostBaseUrl + "supplier/accountInfo.html", null);
	}
	
	/**
	 * 添加供应商收款账户信息
	 * @Title: addAccount 
	 * @author ls
	 */
	@Test
	public void addAccount() {
		String json = getJsonFromFile("/junit/json/supplier/addAccount.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "supplier/addAccount.html", null);
	}
	/**
	 * 添加供应商收款账户信息
	 * @Title: addAccount 
	 * @author ls
	 */
	@Test
	public void regist() {
		String json = getJsonFromFile("/junit/json/supplier/regist.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "supplier/regist.html", null);
	}
	/**
	 * 添加供应商收款账户信息
	 * @Title: addAccount 
	 * @author ls
	 */
	@Test
	public void sendVerifyCode() {
		String json = getJsonFromFile("/junit/json/supplier/sendVerifyCode.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "supplier/sendVerifyCode.html", null);
	}
	
	/**
	* description: 获取供应商简单信息接口
	*@autor:Ding Chengyun
	*@createDate:2014-12-29
	*/
	@Test
	public void supplierSimple() {
		this.sendPostReqOfLocalhost(null, localhostBaseUrl + "supplier/supplierSimple.html?supplierId=1", null);
	}
}
