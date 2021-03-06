/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author frankstar
 *
 */
public class RefererTag extends SimpleTagSupport{
	private String site;
	private String page;
	public void setSite(String site) {
		this.site = site;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String referer = request.getHeader("referer");
		if (referer == null || !referer.startsWith(site)) {
			HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
			String webRoot = request.getContextPath();
			if (page.startsWith(webRoot)) {
				//重定向到page页面
				response.sendRedirect(page);
			} else {
				response.sendRedirect(webRoot + page);
			}
			throw new SkipPageException();
		}
	}
}
