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
public class ChooseTag extends SimpleTagSupport{
	private boolean isExecute;
	
	public void setExecute(boolean isExecute) {
		this.isExecute = isExecute;
	}
	public boolean isExecute() {
		return isExecute;
	}
	
	public void doTag() throws JspException, IOException {
		//输出标签体中的内容
		this.getJspBody().invoke(null);
	}
}
