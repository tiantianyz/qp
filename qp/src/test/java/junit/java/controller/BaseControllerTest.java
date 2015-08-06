package junit.java.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;


/** 
 * Description 
 * @author Ding Chengyun
 * @version 1.0
 * @date 2014-6-24
 */
public class BaseControllerTest {

	protected String baseUrl;
	protected String localhostBaseUrl;

	protected void sendPostReqOfLocalhost(String json, String url, String sessionId) {
		HttpResponse httpResponse;
		HttpPost httpPost = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
			if (!StringUtils.isEmpty(sessionId)) {
				CookieStore cookieStore = httpClient.getCookieStore();
				BasicClientCookie cookie = new BasicClientCookie("JSESSIONID",sessionId );
				cookie.setDomain("localhost");
				cookie.setPath("/zigbee/");
				cookie.setVersion(0);
				cookieStore.addCookie(cookie);
				httpClient.setCookieStore(cookieStore);
			}
			if (!StringUtils.isEmpty(json)) {
				
				StringEntity stringEntity = new StringEntity(json,"utf-8");
				stringEntity.setContentEncoding("UTF-8");
				stringEntity.setContentType("application/json");
				httpPost.setEntity(stringEntity);
				
				InputStream i = stringEntity.getContent();
				BufferedReader b = new BufferedReader(new InputStreamReader(i));
				String l = null;
				StringBuffer s = new StringBuffer();
				while ((l = b.readLine()) != null) {
					s.append(l);
				}
				System.out.println(s.toString());
			}
			httpResponse = httpClient.execute(httpPost);
			InputStream is = httpResponse.getEntity().getContent();
			BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = bfr.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			System.out.println("=============get cookie============");
			List<Cookie> cookies = httpClient.getCookieStore().getCookies();
			for (int i = 0; i < cookies.size(); i++) {
				System.out.println(cookies.get(i).getName() + "      "  +cookies.get(i).getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpPost.abort();
			
		}
	}
	

	protected static String getJsonFromFile(String path) {
		//读取json文件流
		InputStream is = BaseControllerTest.class.getResourceAsStream(path);
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = in.readLine()) != null) {
                buffer.append("\n" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		return buffer.toString();
	}
	
}
