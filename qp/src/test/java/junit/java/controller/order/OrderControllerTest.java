package junit.java.controller.order;

import junit.java.controller.BaseControllerTest;

import org.junit.Before;
import org.junit.Test;

public class OrderControllerTest extends BaseControllerTest{

	@Before
	public void init() {
		localhostBaseUrl = "http://localhost:8080/wxw_web/";
	}
	
	@Test
	public void userOrdersList() {
		String json = getJsonFromFile("/junit/json/order/userOrders.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "order/userOrdersList.html", null);
	}
	@Test
	public void supplierOrders() {
		String json = getJsonFromFile("/junit/json/order/userOrders.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "order/supplierOrders.html", null);
	}
	@Test
	public void modify() {
		String json = getJsonFromFile("/junit/json/order/modify.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "order/modifyConfirm.html", null);
	}
	@Test
	public void userOrderDetail() {
		String json = getJsonFromFile("/junit/json/order/userOrderDetail.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "order/userOrderDetail.html", null);
	}
	@Test
	public void suppOrderDetail() {
		String json = getJsonFromFile("/junit/json/order/suppOrderDetail.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "order/suppOrderDetail.html?", null);
	}
	@Test
	public void add() {
		String json = getJsonFromFile("/junit/json/order/add.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "order/add.html", null);
	}
}
