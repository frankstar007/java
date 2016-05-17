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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * @author frankstar
 * 用来解决get post请求方式下的中文乱码问题
 */
public class CharacterEncodingFilter implements Filter{
	
	private String dafaultCharset = "UTF-8";
	
	private FilterConfig filterConifg = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		//得到web.xml中配置的字符编码
		String charset = filterConifg.getInitParameter("charset");
		if (charset == null) {
			charset = dafaultCharset;
		}
		req.setCharacterEncoding(charset);
		rep.setCharacterEncoding(charset);
		rep.setContentType("text/html;charset=" + charset);
		
		MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(req);
		chain.doFilter(requestWrapper, rep);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConifg = filterConifg;
	}

}
class MyCharacterEncodingRequest extends HttpServletRequestWrapper {
	
	private HttpServletRequest request;
	public MyCharacterEncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
		// TODO Auto-generated constructor stub
	}
	public String getParameter(String name) {
		try {
			String value = this.request.getParameter(name);
			if (value == null) {
				return null;
			}
			if (!this.request.getMethod().equalsIgnoreCase("get")) {
				return value;
			} else {
				value = new String(value.getBytes());
				return value;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	}
	
}
