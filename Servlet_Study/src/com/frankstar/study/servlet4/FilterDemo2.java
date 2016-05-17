package com.frankstar.study.servlet4;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo2 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("---过滤后销毁---");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("执行前");
		chain.doFilter(request, response);
		System.out.println("执行后");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("－－－过滤器初始化－－－");
		String filterName = filterConfig.getFilterName();
		//得到web.xml文件中配置的初始化参数
		String initParam1 = filterConfig.getInitParameter("name");
		String initParam2 = filterConfig.getInitParameter("like");
		Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
		
		System.out.println(filterName);
		System.out.println(initParam1);
		System.out.println(initParam2);
		while (initParameterNames.hasMoreElements()) {
			String paramName = initParameterNames.nextElement();
			System.out.println(paramName);
		}
	}

}
