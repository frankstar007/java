/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author frankstar
 * 实现Tag接口
 */
public class ViewIPTag implements Tag{
	
	//接受传递进来的PageContext对象
	private PageContext pageContext;
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("调用doEndTag()方法");
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("调用doStartTag()方法");
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		JspWriter out = pageContext.getOut();
		String ip = request.getRemoteAddr();
		try {
			out.write(ip);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		System.out.println("调用release()方法");
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		System.out.println("调用pageContext");
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		
	}

}
