package junit.java.controller;

import org.junit.Before;
import org.junit.Test;

/**
 * Description:
 *
 * Author: Ding Chengyun
 * CreateDate:2014-10-29
 * Version：V0.1
 */
public class TestControllerTest extends BaseControllerTest {
	@Before
	public void init() {
		localhostBaseUrl = "http://localhost:8080/wxw_web/";
	}
	
	@Test
	public void setNameTest() {
		String json = getJsonFromFile("/junit/json/test.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "test/test.json", null);
	}
	
}



