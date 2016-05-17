/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author frankstar
 *  标签接收的属性值是一个复合类型 
 */
public class SimpleTagDemo6 extends SimpleTagSupport{
	private Date date;
	public void setDate(Date date) {
		this.date = date;
	}
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().write(date.toLocaleString());
	}
}