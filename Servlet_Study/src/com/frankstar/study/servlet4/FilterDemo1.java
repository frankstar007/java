/**
 * 
 */
package com.frankstar.study.servlet4;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author frankstar
 * Filter开发
 */
public class FilterDemo1 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("－－－过滤器销毁－－－");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("FilterDemo1执行前！");
		chain.doFilter(request, response);
		System.out.println("FilterDemo2执行后！");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("－－－过滤器初始化－－－");
	}

}