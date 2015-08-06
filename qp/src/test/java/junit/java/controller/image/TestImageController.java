package junit.java.controller.image;

import junit.java.controller.BaseControllerTest;

import org.junit.Before;
import org.junit.Test;

public class TestImageController extends BaseControllerTest{

	@Before
	public void init() {
		localhostBaseUrl = "http://localhost:8080/wxw_web/";
	}
	
	@Test
	public void getFPBanner() {
		String json = getJsonFromFile("/junit/json/image/FPBanner.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "image/imageList.json", null);
	}
	@Test
	public void getFPMiddle() {
		String json = getJsonFromFile("/junit/json/image/FPMiddle.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "image/imageList.json", null);
	}
}
