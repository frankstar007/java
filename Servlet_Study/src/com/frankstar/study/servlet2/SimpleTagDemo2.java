/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author frankstar
 * 重写doTag方法 重复调用jspFrament.invoke方法即可
 */
public class SimpleTagDemo2 extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		JspFragment jspFragment = this.getJspBody();
		for (int i = 0; i < 5; i++) {
			jspFragment.invoke(null);
		}
	}
}