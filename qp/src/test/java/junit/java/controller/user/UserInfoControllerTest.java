package junit.java.controller.user;

import junit.java.controller.BaseControllerTest;

import org.junit.Before;
import org.junit.Test;

public class UserInfoControllerTest extends BaseControllerTest {

    @Before
    public void init() {
        localhostBaseUrl = "http://localhost:8080/wxw_web";
    }
    
    @Test
    public void regist() {
        String json = getJsonFromFile("/junit/json/user/regist.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/regist.html", null);
    }    
    @Test
    public void login() {
        String json = getJsonFromFile("/junit/json/user/login.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/login.html", null);
    }    
    @Test
    public void logout() {
        this.sendPostReqOfLocalhost("", localhostBaseUrl + "/user/logout.html", null);
    }    
    @Test
    public void modifyPwd() {
        String json = getJsonFromFile("/junit/json/user/modifyPwd.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/modifyPwd.html", null);
    }    
    @Test
    public void emailOpt_1() {
        String json = getJsonFromFile("/junit/json/user/emailOpt_type_1.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/emailOpt.html", null);
    }    
    @Test
    public void emailOpt_2() {
        String json = getJsonFromFile("/junit/json/user/emailOpt_type_2.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/emailOpt.html", null);
    }    
    @Test
    public void emailOpt_3() {
        String json = getJsonFromFile("/junit/json/user/emailOpt_type_3.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/emailOpt.html", null);
    }    
    @Test
    public void userDetail() {
        this.sendPostReqOfLocalhost("", localhostBaseUrl + "/user/userDetail.html", null);
    }    
    @Test
    public void modifyUser() {
        String json = getJsonFromFile("/junit/json/user/modifyUser.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/modifyUser.html", null);
    }    
    @Test
    public void collect_1_collected() {
        String json = getJsonFromFile("/junit/json/user/collect_1_collected.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/collect.html", null);
    }    
    @Test
    public void collect_1_uncollected() {
        String json = getJsonFromFile("/junit/json/user/collect_1_uncollected.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/collect.html", null);
    }    
    @Test
    public void collectList() {
        String json = getJsonFromFile("/junit/json/user/collectList.json");
        this.sendPostReqOfLocalhost(json, localhostBaseUrl + "/user/collectList.html", null);
    }    
    @Test
    public void verifyEmail() {
        this.sendPostReqOfLocalhost("", localhostBaseUrl + "/verifyEmail.html", null);
    }    
}
