package com.qp.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.util.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qp.basic.util.JsonUtil;
import com.qp.bean.response.TokenRspBean;
import com.qp.constant.CommConstant;


@RequestMapping(value = "/wxOper")
@Controller
public class wxController {
//	private String appId="wxe63bb775563616d7";
//	private String appSecret="402fea1783fa4047fee0a45c49729ddf";
	private String appId="wx6da52a998f50022b";
	private String appSecret="fe20a1c6de3a9e2b5924f4ab3941e692";
    @RequestMapping(value = "getOpenId.html") 
    public void getOpenId(HttpServletRequest request,HttpServletResponse response) {
    	TokenRspBean rspBean=null;
    	 try {
    		String code = request.getParameter("code");
    		String urlPath="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appId+"&secret="+appSecret+"&code="+code+"&grant_type=authorization_code";
			URL url = new URL(urlPath);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			//对应的字符编码转换
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
			reader.close();
			connection.disconnect();
	    	rspBean = JsonUtil.getInstance().fromJson(sb.toString(), TokenRspBean.class);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("openId", rspBean.getOpenid());
	    	session.setAttribute("accessToken", rspBean);
	    	response.setContentType("text/html");
	    	response.setCharacterEncoding("utf-8");
	    	request.getRequestDispatcher(request.getContextPath()+"/pages/getCode.jsp").forward(request, response);
		} catch (Exception e) {
			Log.info(e.getMessage());
			rspBean.setMessageCode(CommConstant.ERROR_CODE_PLAT_ERROR);
			rspBean.setDescription(CommConstant.ERROR_DESC_PLAT_ERROR);
		}
    }
}
