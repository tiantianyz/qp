package junit.java.controller.common;

import junit.java.controller.BaseControllerTest;

import org.junit.Before;
import org.junit.Test;

public class CommonControllerTest extends BaseControllerTest {

	@Before
	public void init() {
		localhostBaseUrl = "http://localhost:8080/wxw_web/";
	}
	
	/**
	 * 常见问题列表信息
	* @Title: faqList 
	* @author ls
	 */
	@Test
	public void faqList() {
		String json = getJsonFromFile("/junit/json/common/faqList.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "common/faqList.html", null);
	}
	/**
	 * 问答列表
	* @Title: consultList 
	* @author ls
	 */
	@Test
	public void consultList() {
		String json = getJsonFromFile("/junit/json/common/consultList.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "common/consultList.html", null);
	}
	/**
	 * 热门评论列表
	* @Title: consultList 
	* @author ls
	 */
	@Test
	public void commentList() {
		String json = getJsonFromFile("/junit/json/common/commentList.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "common/commentList.html", null);
	}
	/**
	 * 提问问题
	 * @Title: consultList 
	 * @author ls
	 */
	@Test
	public void addConsult() {
		String json = getJsonFromFile("/junit/json/common/addConsult.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "common/addUserConsult.html", null);
	}
	/**
	 * 提问问题
	 * @Title: consultList 
	 * @author ls
	 */
	@Test
	public void addComment() {
		String json = getJsonFromFile("/junit/json/common/addComment.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "common/addComment.html", null);
	}
	
	/**
	* description: 首页城市之旅
	*@autor:Ding Chengyun
	*@createDate:2014-12-27
	*/
	@Test
	public void cityTravel() {
		this.sendPostReqOfLocalhost(null, localhostBaseUrl + "common/cityTravel.html", null);
	}
	
	/**
	* description: 获取主题列表
	*@autor:Ding Chengyun
	*@createDate:2014-12-27
	*/
	@Test
	public void themeList() {
		this.sendPostReqOfLocalhost(null, localhostBaseUrl + "common/themeList.html", null);
	}
	/**
	* description: 首页缤纷主题
	*@autor:Ding Chengyun
	*@createDate:2014-12-27
	*/
	@Test
	public void firstPageTheme() {
		this.sendPostReqOfLocalhost(null, localhostBaseUrl + "common/firstPageTheme.html", null);
	}
	/**
	* description: 首页促销活动列表
	*@autor:Ding Chengyun
	*@createDate:2014-12-27
	*/
	@Test
	public void getSalesList() {
		this.sendPostReqOfLocalhost(null, localhostBaseUrl + "common/getSalesList.html", null);
	}
	/**
	* description: 查询促销活动详情
	*@autor:Ding Chengyun
	*@createDate:2014-12-27
	*/
	@Test
	public void getSalesDetail() {
		this.sendPostReqOfLocalhost(null, localhostBaseUrl + "common/getSalesDetail.html?salesId=1", null);
	}
	
	@Test
	public void fpStrategyList() {
		this.sendPostReqOfLocalhost(null, localhostBaseUrl + "common/fpStrategyList.html", null);
	}
	@Test
	public void strategyDetail() {
		String json = getJsonFromFile("/junit/json/common/strategyDetail.json");
		this.sendPostReqOfLocalhost(json, localhostBaseUrl + "common/strategyDetail.html", null);
	}
	
}
