package me.frankstar.JSPstudy1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorld extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("Hello world " + new java.util.Date());
	}
}
