package junit.java.controller.product;

import junit.java.controller.BaseControllerTest;

import org.junit.Before;
import org.junit.Test;

public class ProductControllerTest extends BaseControllerTest {

	@Before
	public void init() {
		localhostBaseUrl = "http://localhost:8080/wxw_web/";
	}
	
	/**
	* description: 用户获取商品列表接口
	*@autor:Ding Chengyun
	*@createDate:2014-12-13
	*/
	@Test
	public void productListTest() {
		String json = getJsonFromFile("/junit/json/product/productList.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "product/productList.html", null);
	}
	
	/**
	* description: 商户获取商品列表接口
	*@autor:Ding Chengyun
	*@createDate:2014-12-13
	*/
	@Test
	public void productListSuppTest() {
		String json = getJsonFromFile("/junit/json/product/productListSupp.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "product/productListSupp.html", null);
	}
	
	/**
	* description: 添加产品接口测试
	*@autor:Ding Chengyun
	*@createDate:2014-12-13
	*/
	@Test
	public void addProductTest() {
		String json = getJsonFromFile("/junit/json/product/addProduct1.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "product/addProduct.html", null);
	}
	
	/**
	* description: 修改产品信息接口测试
	*@autor:Ding Chengyun
	*@createDate:2014-12-13
	*/
	@Test
	public void updateProductTest() {
		String json = getJsonFromFile("/junit/json/product/updateProduct.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "product/updateProduct.html", null);
	}
	
	/**
	* description: 查询产品详情接口测试
	*@autor:Ding Chengyun
	*@createDate:2014-12-13
	*/
	@Test
	public void getProductDetailTest() {
		this.sendPostReqOfLocalhost("", localhostBaseUrl + "product/onshelf.html", null);
	}
	
	/**
	* description: 查询用户最近浏览/感兴趣产品列表接口测试
	*@autor:Ding Chengyun
	*@createDate:2014-12-13
	*/
	@Test
	public void getRecentProductList() {
		String json = getJsonFromFile("/junit/json/product/pruductRecentList.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "product/recentProductList.html", null);
	}

	/**
	* description: 查询季节促销相关产品列表接口测试
	*@autor:Ding Chengyun
	*@createDate:2014-12-24
	*/
	@Test
	public void getSalesProductsTest() {
		this.sendPostReqOfLocalhost("", localhostBaseUrl + "product/getSalesProducts.html?salesId=1", null);
	}
	
}
