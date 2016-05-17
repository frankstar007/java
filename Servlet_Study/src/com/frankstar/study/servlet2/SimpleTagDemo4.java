/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author frankstar
 * 控制整个jsp页面是否执行
 */
public class SimpleTagDemo4 extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
}