/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author frankstar
 * 通过标签的属性控制标签体的执行次数
 */
public class SimpleTagDemo5 extends SimpleTagSupport{
	private int count;
	public void setCount(int count) {
		this.count = count;
	}
	
	public void doTag() throws JspException, IOException {
		for (int i = 0; i < count; i++) {
			this.getJspBody().invoke(null);
		}
	}
}
