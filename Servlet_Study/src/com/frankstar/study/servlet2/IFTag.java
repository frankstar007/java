/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author frankstar
 *
 */
public class IFTag extends SimpleTagSupport {
	private boolean test;
	
	public void doTag() throws JspException, IOException {
		if (test) {
			this.getJspBody().invoke(null);
		}
	}
	public void setTest(boolean test) {
		this.test = test;
	}
}
