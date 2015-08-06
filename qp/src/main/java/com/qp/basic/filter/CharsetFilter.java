package com.qp.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {
	
	private String CHARSET = "utf-8";

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(CHARSET);
		response.setCharacterEncoding(CHARSET);
		//response.setContentType("text/html; charset=" + CHARSET);	
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String charset = config.getInitParameter("charset");
		if (charset != null	&& charset.length() > 0) {
			CHARSET = charset;
		}
	}

}
