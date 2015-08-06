package junit.java.controller.area;

import junit.java.controller.BaseControllerTest;

import org.junit.Before;
import org.junit.Test;
/**
 * 区域测试类
* @ClassName: AreaControllerTest 
* @Description:
* @author ls
* @date 2014-11-22 下午5:27:28
 */
public class TestAreaController extends BaseControllerTest {

	@Before
	public void init() {
		localhostBaseUrl = "http://localhost:8080/wxw_web/";
	}
	
	@Test
	public void homePageAreas() {
		String json = getJsonFromFile("/junit/json/area/homePageAreas.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "area/homePageAreas.html", null);
	}
	@Test
	public void subAreas() {
		String json = getJsonFromFile("/junit/json/area/subAreas.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "area/subAreas.html", null);
	}
}
